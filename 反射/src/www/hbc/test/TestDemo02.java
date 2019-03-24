package www.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/22 22:54
 * @Description:三种实例化对象
 */

import java.util.Date;

import static java.lang.Class.forName;

/**
 * 1. 任何类的实例化对象可以通过Object类中的getClass()方法取得Class类对象。
 * 2. "类.class":直接根据某个具体的类来取得Class类的实例化对象。
 * 3. 使用Class类提供的方法:public static Class<?> forName(String className) throws
 * ClassNotFoundException
 */
public class TestDemo02 {
//    public static void main(String[] args) throws ClassNotFoundException{
//        Date date = new Date();
//        System.out.println(date.getClass());//结果：class java.util.Date
//        Class<?> cls = Class.forName("java.util.Date");
//        System.out.println(cls.getName());//结果：java.util.Date
//    }
    public static void main(String[] args) throws ClassNotFoundException,IllegalAccessException, InstantiationException {
        Class<?> cls = Class.forName("java.util.Date");
        Object obj = cls.newInstance();//实例化对象，等价于new java.util.Date();
        System.out.println(obj);//结果：Fri Mar 22 23:40:14 CST 2019
    }
}
