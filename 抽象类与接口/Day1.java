/**
 *  1.所有的抽象类必须有子类。
 *  2.抽象类的子类必须覆写抽象类的所有抽象方法（子类不是抽象类）
 *  【方法覆写一定要考虑权限问题，权限尽量都用public】
 *  3.抽象类的对象可以通过对象多态性利用子类为其实例化
 *  4.private与abstract不能同时使用。
*/
abstract class Person {
    private String name;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract void getPersonInFo();
    public static Person getInstance() {
        class Student extends Person {
            public void getPersonInFo() {
                System.out.println("Hellow world!!!");
            }
        }
        return new Student();
    }
}
public class Day1 {
    public static void main(String[] args) {
        Person per = Person.getInstance();
        per.getPersonInFo();
    }
}
