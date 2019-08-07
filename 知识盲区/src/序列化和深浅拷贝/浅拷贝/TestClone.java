package 序列化和深浅拷贝.浅拷贝;

/**
 * @Author: Beer
 * @Date: 2019/8/7 12:51
 * @Description:
 */

class Teacher {
    private String name;
    private String lesson;

    public Teacher(String name, String lesson) {
        this.name = name;
        this.lesson = lesson;
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

class Student implements Cloneable {
    private String name;
    private Integer age;
    private Teacher teacher;

    public Student(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public Student clone() throws CloneNotSupportedException {
        Student stu = null;
        stu = (Student) super.clone();
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}


public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher("Beer","Java");
        Student student = new Student("Wine",20,teacher);
        Student stu = student.clone();
        System.out.println(student);
        System.out.println(stu);
        System.out.println(teacher);
        System.out.println(stu.getTeacher());
        System.out.println(student.getName()==stu.getName());
        System.out.println(student.getAge() == stu.getAge());
    }
    /**
     * 结果：
     * 序列化和深浅拷贝.浅拷贝.Student@1540e19d
     * 序列化和深浅拷贝.浅拷贝.Student@677327b6
     * 序列化和深浅拷贝.浅拷贝.Teacher@14ae5a5
     * 序列化和深浅拷贝.浅拷贝.Teacher@14ae5a5
     * true
     * true
     */
}

