package www.hbc.test.enumDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/20 14:29
 * @Description:枚举应用
 */
enum Sex {
    MALE("男性"),FEMALE("女性");
    private String title;
    private Sex(String title) {
        this.title = title;
    }
    public String toString() {
        return this.title;
    }
}
class Person {
    private  String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public String toString() {
        return "Person[name:" + name +
                ",age:" + age +",sex:" +
                sex + "]";
    }
}
public class TestDemo04 {
    public static void main(String[] args) {
        Person  per = new Person("张三",20,Sex.MALE);
        System.out.println(per);
    }
}
