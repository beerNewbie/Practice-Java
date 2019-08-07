package 序列化和深浅拷贝.深拷贝;


/**
 * @Author: Beer
 * @Date: 2019/8/7 13:47
 * @Description:
 */

class Teacher1 implements Cloneable{
    private String name;
    private String lesson;

    public Teacher1(String name, String lesson) {
        this.name = name;
        this.lesson = lesson;
    }

    public Teacher1 clone() throws CloneNotSupportedException {
        Teacher1 teacher1 = null;
        teacher1 = (Teacher1) super.clone();
        return teacher1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

}

class Student1 implements Cloneable{
    private String name;
    private Integer age;
    private Teacher1 teacher;

    public Student1(String name, Integer age, Teacher1 teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public Student1 clone() throws CloneNotSupportedException {
        Student1 stu = null;
        stu = (Student1) super.clone();
        stu.teacher = this.teacher.clone();
        return stu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher1 getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher1 teacher) {
        this.teacher = teacher;
    }

}

public class TestClone2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher1 teacher = new Teacher1("Beer","Java");
        Student1 student = new Student1("Wine",20,teacher);
        Student1 stu = student.clone();
        System.out.println(student);
        System.out.println(stu);
        System.out.println(teacher);
        System.out.println(stu.getTeacher());
        System.out.println(student.getName()==stu.getName());
        System.out.println(student.getAge() == stu.getAge());
    }
    /**
     * 结果：
     * 序列化和深浅拷贝.深拷贝.Student1@1540e19d
     * 序列化和深浅拷贝.深拷贝.Student1@677327b6
     * 序列化和深浅拷贝.深拷贝.Teacher1@14ae5a5
     * 序列化和深浅拷贝.深拷贝.Teacher1@7f31245a
     * true
     * true
     */
}
