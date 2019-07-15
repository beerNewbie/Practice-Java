package com.hbc;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import com.hbc.annotation.Benchmark;
import com.hbc.annotation.Measurement;

/**
 * @Author: Beer
 * @Date: 2019/7/15 17:30
 * @Description:
 *
 * 找到com.hbc.cases下的所有类-->找到存放com.hbc.cases这
 * 个包的目录-->扫描这个目录下的所有*.class
 *
 * URLDecoder.decode(url.getPath(),"UTF-8")解码
 *
 * 判断某一个类是否实现某接口（类）：
 *      if (Case.class.isAssignableFrom(cls（子类）))
 *
 * 根据类名
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //找目录：
        ClassLoader classLoader = Main.class.getClassLoader();
        Enumeration<URL> urls = classLoader.getResources("com/hbc/cases");
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            /**
             * System.out.println(URLDecoder.decode(url.getPath(),"UTF-8"));///C:/Users/DELL/Desktop/Java code/Practice-Java/project_practice/autoloader/target/classes/com/hbc/cases
             * System.out.println(url.getProtocol());//file
             * 只能处理*.class情况，无法处理打成jar包的情况
             */
            File dir = new File(URLDecoder.decode(url.getPath(),"UTF-8"));
            if (!dir.isDirectory()) {
                continue;
            }

            File[] files = dir.listFiles();
            if (files == null) {
                continue;
            }

            for (File file : files) {
                String fileName = file.getName();
                String className = fileName.substring(0,fileName.length()-6);
                //System.out.println(className);

                Class<?> clss = Class.forName("com.hbc.cases."+className);

                //利用Case接口，找出需要处理的Class
                if (Case.class.isAssignableFrom(clss)) {
                    System.out.println(className);

                    int iterations = 10;
                    int group = 5;

                    Class<?> cls = Class.forName("com.hbc.cases."+className);
                    Object obj = cls.newInstance();
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
        }
    }
}
