package www.hbc.test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: Beer
 * @Date: 2019/3/30 13:36
 * @Description:
 */
public class ReflectDemo01 {
    //通过反射获取类
    public static void demo01() {
        //获取反射对象（反射入口）：Class： 1：Class.forName(全类名)  2: 类名.class  3: 对象.getClass()
        //1：Class.forName(全类名)
        try {
            Class<?> perClass = Class.forName("www.hbc.test2.Person");
            System.out.println(perClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2: 类名.class
        Class<?> perClass2 = Person.class;
        System.out.println(perClass2);

        //3: 对象.getClass()
        Person per = new Person();
        Class<?> perClass3 = per.getClass();
        System.out.println(perClass3);
    }

    //获取公共方法
    public static void demo02() {
        //Class入口
        Class<?> perClass = null;
        try {
            perClass = Class.forName("www.hbc.test2.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取所有的公共的方法（1.本类以及父类、接口中的所有方法 2.符合访问修饰符规律）
        Method[] methods = perClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("--------");
        //获取当前类的所有方法（1：当前类  2：忽略访问修饰符限制）
        Method[] declaredMethods = perClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

    }

    //获取所有的接口
    public static void demo03() {
        Class<?> perClass = null;
        try {
            perClass = Class.forName("www.hbc.test2.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?>[] interfaces = perClass.getInterfaces();
        for (Class<?> interface1 : interfaces) {
            System.out.println(interface1);
        }
    }

    //获取所有的父类
    public static void demo04() {
        Class<?> perClass = null;
        try {
            perClass = Class.forName("www.hbc.test2.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> superclass = perClass.getSuperclass();
        System.out.println(superclass);

    }

    //获取所有的构造方法
    public static void demo05() {
        Class<?> perClass = null;
        try {
            perClass = Class.forName("www.hbc.test2.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] constructors = perClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }

    //获取所有的公共属性
    public static void demo06() {
        Class<?> perClass = null;
        try {
            perClass = Class.forName("www.hbc.test2.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields = perClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------------");
        //所有属性
        Field[] declaredFields = perClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    //获取当前反射所代表类（接口）的对象（实例）
    public static void demo07() throws IllegalAccessException, InstantiationException {
        Class<?> perClass = null;
        try {
            perClass = Class.forName("www.hbc.test2.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object instance = perClass.newInstance();
        Person per = (Person) instance;
        per.interfaceMethod2();
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        demo01();
        /**
         * 结果：
         * class www.hbc.test2.Person
         * class www.hbc.test2.Person
         * class www.hbc.test2.Person
         */
        //demo02();
        /**
         * 结果
         * public java.lang.String www.hbc.test2.Person.getName()
         * public int www.hbc.test2.Person.getId()
         * public void www.hbc.test2.Person.setName(java.lang.String)
         * public void www.hbc.test2.Person.setAge(int)
         * public void www.hbc.test2.Person.intfaceMethod()
         * public static void www.hbc.test2.Person.staticMethod()
         * public void www.hbc.test2.Person.interfaceMethod2()
         * public void www.hbc.test2.Person.setId(int)
         * public int www.hbc.test2.Person.getAge()
         * public final void java.lang.Object.wait() throws java.lang.InterruptedException
         * public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
         * public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
         * public boolean java.lang.Object.equals(java.lang.Object)
         * public java.lang.String java.lang.Object.toString()
         * public native int java.lang.Object.hashCode()
         * public final native java.lang.Class java.lang.Object.getClass()
         * public final native void java.lang.Object.notify()
         * public final native void java.lang.Object.notifyAll()
         * --------
         * public java.lang.String www.hbc.test2.Person.getName()
         * public int www.hbc.test2.Person.getId()
         * public void www.hbc.test2.Person.setName(java.lang.String)
         * public void www.hbc.test2.Person.setAge(int)
         * private void www.hbc.test2.Person.privateMethod()
         * public void www.hbc.test2.Person.intfaceMethod()
         * public static void www.hbc.test2.Person.staticMethod()
         * private void www.hbc.test2.Person.privateMethod2(java.lang.String)
         * public void www.hbc.test2.Person.interfaceMethod2()
         * public void www.hbc.test2.Person.setId(int)
         * public int www.hbc.test2.Person.getAge()
         */
        //demo03();
        /**
         * 结果：
         * interface www.hbc.test2.MyInterface
         * interface www.hbc.test2.MyInterface2
         */
        //demo04();//结果：class java.lang.Object
        //demo05();
        /**
         * 结果：
         * public www.hbc.test2.Person(int)
         * public www.hbc.test2.Person()
         * public www.hbc.test2.Person(int,java.lang.String,int)
         */
        //demo06();
        /**
         * 结果：
         * public java.lang.String www.hbc.test2.Person.desc
         * ---------------
         * private int www.hbc.test2.Person.id
         * private java.lang.String www.hbc.test2.Person.name
         * private int www.hbc.test2.Person.age
         * public java.lang.String www.hbc.test2.Person.desc
         */
        demo07();//结果：interface2 Method
    }
}
