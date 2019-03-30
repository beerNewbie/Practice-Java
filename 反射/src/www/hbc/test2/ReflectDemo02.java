package www.hbc.test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Author: Beer
 * @Date: 2019/3/30 15:52
 * @Description:
 */
//
public class ReflectDemo02 {
    //获取对象的实例 ，并操作对象
    public static void demo01() throws IllegalAccessException, InstantiationException {
        //Class入口
        Class<?> perClass = null;
        try {
            perClass = Class.forName("www.hbc.test2.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person per = (Person) perClass.newInstance();
        per.setName("张三");
        per.setAge(20);
        System.out.println(per.getName()+", "+per.getAge());

    }

    //操作属性
    public static void demo02() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //Class入口
        Class<?> perClass = null;
        try {
            perClass = Class.forName("www.hbc.test2.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person per = (Person) perClass.newInstance();
        Field idField = perClass.getDeclaredField("id");
        //访问的是private修饰的id，修改属性（方法、构造方法）的访问权限：Field/Method/Constructor.setAccessible()
        idField.setAccessible(true);
        idField.set(per,1);//相当于per.setId(val)
        System.out.println(per.getId());
        System.out.println("---------------");
        Method method = perClass.getDeclaredMethod("privateMethod", null);
        method.setAccessible(true);
        method.invoke(per,null);//方法的调用：invoke()
        Method method2 = perClass.getDeclaredMethod("privateMethod2", String.class);
        method2.setAccessible(true);
        method2.invoke(per,"张三");
    }

    //操作构造方法
    public static void demo03() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //Class入口
        Class<?> perClass = null;
        try {
            perClass = Class.forName("www.hbc.test2.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Constructor<?>[] constructors = perClass.getConstructors();//公共
//        for (Constructor constructor : constructors) {
//            System.out.println(constructor);
//        }
//        Constructor<?>[] constructors = perClass.getDeclaredConstructors();//本类全部
//        for (Constructor constructor : constructors) {
//            System.out.println(constructor);
//        }
        //获取指定的构造方法
        //在反射中，根据类型获取方法时：基本数据类型（int、char...）和包装类（Integer、Character...)是不同的类型
        Constructor<?> constructor = perClass.getConstructor(int.class);//换成Integer的话出现：NoSuchMethodException
        System.out.println(constructor);

        Constructor<?> constructor2 = perClass.getDeclaredConstructor(String.class);
        System.out.println(constructor2);
        //根据获取的private构造方法，获取对象实例
        constructor2.setAccessible(true);
        Person instance3 = (Person)constructor2.newInstance("张三");
        System.out.println("instance3:"+instance3);

        Person instance2 = (Person)constructor.newInstance(18);//constructor是有参构造（int），因此需要传入int值
        System.out.println(instance2);

        Constructor<?> constructor3 = perClass.getConstructor();
        Person instance = (Person)constructor3.newInstance();//constructor3是无参构造，因此不需要传参
        System.out.println(instance);
    }

    //反射可以越过泛型检查(不建议，可能造成程序混乱)
    public static void demo05() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add("a");
        Class<?> listClass = list.getClass();
        Method method = listClass.getMethod("add", Object.class);
        method.invoke(list,"a");
        System.out.println(list);
    }

    //创建set方法对任何对象任何属性进行赋值
    public static void demo06() throws NoSuchFieldException, IllegalAccessException {
        Person per = new Person();
        PropertyUtil.setProperty(per,"name","张三");
        PropertyUtil.setProperty(per,"age",20);
        PropertyUtil.setProperty(per,"id",101);
        System.out.println("name:"+per.getName()+", age:"+per.getAge()+", ID:"+per.getId());
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        demo01();
        /**
         * 结果：
         * 张三, 20
         */
        //demo02();
        /**
         * 结果：
         * 1
         * ---------------
         * private Method...
         * private Method2...张三
         */
        //demo03();
        /**
         * 结果：
         * public www.hbc.test2.Person(int)
         * private www.hbc.test2.Person(java.lang.String)
         * instance3:www.hbc.test2.Person@1540e19d
         * www.hbc.test2.Person@677327b6
         * www.hbc.test2.Person@14ae5a5
         */
        //demo05();//结果：[1,2,3,a]
        demo06();//结果：name:张三, age:20, ID:101
    }
}


