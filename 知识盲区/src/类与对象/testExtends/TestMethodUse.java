package 类与对象.testExtends;

import static 类与对象.testExtends.Student.staticFunSon;

/**
 * @Author: Beer
 * @Date: 2019/6/8 1:17
 * @Description: 父类子类间实例方法与与类方法间的相互调用
 */

class Person {
    public String name;
    public static Integer age;

    /**
     * 构造方法
     */
    public Person() {

    }

    /**
     * 实例方法
     */
    public void fun() {
        //funSon();//无法调用子类
        staticFunSon();//除非导入import static 类与对象.testExtends.Student.staticFunSon;否则编译不通过

        System.out.println("父类的普通方法");
    }

    /**
     * 类方法
     */
    public static void staticFun() {
        System.out.println("父类的静态（类）方法");
    }
}

class Student extends Person {
    public String sex;
    public static Integer ID;

    public Student() {

    }
    /**
     * 实例方法
     */
    public void funSon() {
        fun();
        staticFun();
        funSon2();
        System.out.println("子类的普通方法");
    }

    public void funSon2() {
        System.out.println("子类的实例方法");
    }
    /**
     * 类方法
     */
    public static void staticFunSon() {
        //fun();//编译不通过
        staticFun();
        System.out.println("子类的静态（类）方法");
    }

}
public class TestMethodUse {
    public static void main(String[] args) {
        Person per = new Student();
        ((Student) per).funSon();

        /**
         * 结果：
         * 父类的静态（类）方法
         * 子类的静态（类）方法
         * 父类的普通方法
         * 父类的静态（类）方法
         * 子类的实例方法
         * 子类的普通方法
         */
    }
}
