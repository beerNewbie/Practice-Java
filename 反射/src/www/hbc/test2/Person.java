package www.hbc.test2;

/**
 * @Author: Beer
 * @Date: 2019/3/30 13:30
 * @Description:
 */
public class Person implements MyInterface,MyInterface2{
    private  int id;
    private String name;
    private int age;
    public String desc;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {}

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void privateMethod() {
        System.out.println("private Method...");
    }

    private void privateMethod2(String name) {
        System.out.println("private Method2..." + name);
    }

    @Override
    public void intfaceMethod() {
        System.out.println("interface Method ...");
    }

    @Override
    public void interfaceMethod2() {
        System.out.println("interface2 Method");
    }

    public static void staticMethod() {
        System.out.println("static Method ...");
    }
}
