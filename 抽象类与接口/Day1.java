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