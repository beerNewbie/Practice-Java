package pers.hbc.oo;

/**
 * 方法的重写要符合3个要求:
 *      1.方法名、形参列表相同；
 *      2.返回值类型和声明异常类型 ，子类小于等于父类；
 *      3.访问权限，子类大于等于父类
 */
public class TestOverride {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.run();
    }
}
class Vehicl {
    public void run() {
        System.out.println("跑....");
    }
    public void stop() {
        System.out.println("停止");
    }

    public Person whoIsPsg() {
        return new Person();
    }
}
class Horse extends Vehicl  {
    public void run() {
        System.out.println("马踏斜日");
    }

    public Student whoIsPsg() {//子类返回值类型Student小于Person
        return new Student();
    }
}
