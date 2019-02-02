class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "姓名："+this.name+"，年龄："+this.age;
    }
}
class Student {}
public class Test {
    public static void main(String[] args) {
        fun(new Person("李华", 19));
        fun("hello");
        String msg = "hello" + new Person("张三", 20);
        System.out.println(msg);
    }
    public static void fun(Object obj) {
        System.out.println(obj.toString());
        /**
         * 默认Object类提供的toString()方法只能够得到一个对象的地址（而这是所有对象都共同具备
         * 的特征）。如若觉得默认给出的toString()方法功能不足，就在需要的子类上覆写toString()方法。
         */
    }
}
