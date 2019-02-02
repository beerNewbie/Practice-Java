/**
 * Object类是JDK默认提供的一个类，所有类默认继承Object类。
 * Object类是所有类的父类，使用Object可以接收所有类的对象。
 */
class Person {}
class Student {}
public class Test {
    public static void fun(Object obj) {
        System.out.println(obj);
    }
    public static void main(String[] args) {
        fun(new Person());
        fun(new Student());
    }
}
