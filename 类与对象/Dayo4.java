/**
 1. 继承的语法以及继承的目的（扩展已有类的功能，使代码重用）
 2. 子类对象的实例化流程：不管如何操作，一定要先实例化父类对象。
 3. 不允许多重继承，只允许多层继承。
 */
class Person {
    private String name;
    private int age;
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
}
class Students extends Person {
    private String school;
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school;
    }
}
public class Day1 {
    public static void  main(String[] args) {
        Students student = new Students();
        student.setName("张三");
        student.setAge(20);
        student.setSchool("北京大学");
        System.out.println("姓名："+student.getName()+",年龄："+student.getAge()+"，学校："+student.getSchool());
    }
}
