package pers.hbc.oo;

public class TestExtends {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.name = "zhang";
        stu1.hight = 170;
        stu1.major = "math";
        stu1.rest();
        Student stu2 = new Student("li",180,"paint");
        stu2.study();
        System.out.println(stu1 instanceof Student);//当对象是右边类或子类所创建对象时返回true
        System.out.println(stu2 instanceof Person);
        System.out.println(new Student() instanceof Person);
        System.out.println(new Person() instanceof Object);
    }
}

class Person {
    String name;
    int hight;

    public void rest() {
        System.out.println("休息半小时");
    }
}
class Student extends Person {
    String major;

    public void study() {
        System.out.println("学习两小时");
    }
    public Student(String name, int hight, String major) {
        this.name = name;
        this.hight = hight;
        this.major = major;
    }

    public Student() {
    }
}
