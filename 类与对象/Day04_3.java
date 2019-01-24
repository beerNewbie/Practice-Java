   //super调用父类属性

/**
 * super与this的区别：
 *      概念：super：由子类访问父类中的属性方法
 *            this：访问本类中的属性方法（还表示当前对象）
 *      查找范围：super：不查找本类而直接调用父类
 *                this：先查找本类，如果本类 没有就调用父类
 */
class Person {
    public String msg = "Fathere";
}
class Student extends Person {
    public String msg = "Child";
    public void print() {
        System.out.println(super.msg);
        System.out.println(this.msg);
    }
}
public class Day1 {
    public static void main(String[] args) {
        new Student().print();
    }
}
