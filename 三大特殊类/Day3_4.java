class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "姓名："+this.name+",年龄："+this.age;
    }
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;//向下转型，比较属性值
        return this.name.equals(person.name) && this.age == person.age;
    }
}
public class Test {
    public static void main(String[] args) {
        Person per1 = new Person("张三", 19);
        Person per2 = new Person("张三", 19);
        System.out.println(per1.equals(per2));
    }
}
