package pers.hbc.oo;

public class TestObject {
    public static void main(String[] args) {
        TestObject to = new TestObject();
        System.out.println(to.toString());

        Person2 per2 = new Person2("zhang",19);
        System.out.println(per2.toString());
    }
    public String toString() {
        return "test";
    }
}

class Person2 {
    String name;
    int age;

    public String toString() {
        return name+",年龄："+age;
    }
    public Person2(String name,int age) {
        this.name = name;
        this.age = age;
    }
}
