import annotations.Benchmark;
import annotations.Measurement;
import cases.StringConnectCase;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Beer
 * @Date: 2019/7/15 15:35
 * @Description:
 */
@Measurement(iterations = 100, group = 5)
public class Main {
    //注解使用测试
    public static void main1(String[] args) {
        Class<?> cls = Main.class;
        Annotation annotation = cls.getAnnotation(Measurement.class);
        if (annotation == null) {
            System.out.println("没有使用Measurement注解");
            return;
        }
        Measurement measurement = (Measurement) annotation;
        System.out.println(measurement.group());
        System.out.println(measurement.iterations());

    }

    //
    public static void main(String[] args) {
        //默认配置
        int iterations = 10;
        int group = 5;
        StringConnectCase obj = new StringConnectCase();
        Class<?> cls = obj.getClass();
        //二级配置（类级别）
        Annotation annotationMeasurement = cls.getAnnotation(Measurement.class);
        if (annotationMeasurement != null) {
            Measurement measurement = (Measurement) annotationMeasurement;
            iterations = measurement.iterations();
            group = measurement.group();
        }

        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            Annotation annotation = method.getAnnotation(Benchmark.class);
            if (annotation == null) {
                continue;
            }

            //针对方法的配置
            int methodIterations = iterations;
            int methodGroup = group;
            System.out.println(method.getName());
            Annotation methodAnnotation = method.getAnnotation(Measurement.class);
            if (methodAnnotation != null) {
                Measurement methodMeasurement = (Measurement) methodAnnotation;
                methodIterations = methodMeasurement.iterations();
                methodGroup = methodMeasurement.group();
            }

            //调用对象的测试实例方法
            for (int i = 0; i < methodGroup; i++) {
                long t1 = System.nanoTime();
                for (int j = 0; j < methodIterations; j++) {
                    try {
                        method.invoke(obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
                long t2 = System.nanoTime();
                System.out.println("第" + (i + 1) + "组实验耗时：" + (t2 - t1) + "纳秒");
            }
        }
    }
}
