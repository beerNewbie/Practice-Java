class Person {
    private  String name;
    private int age;
    public Person(String n, int i) {
        name = n;
        setAge(i);
    }
    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }
    public void setAge(int i) {
        if (i>0 && i<200) {
            age = i;
        }else {
            age = 0;
        }
    }
    public int getAge() {
        return age;
    }
    public void getPersonInfo() {
        System.out.println("姓名："+name+",年龄："+age);
    }
}
public class Day01 {
    public static void main(String[] args) {
        Person per = new Person("张三",20);
        per.getPersonInfo();
    }
}
