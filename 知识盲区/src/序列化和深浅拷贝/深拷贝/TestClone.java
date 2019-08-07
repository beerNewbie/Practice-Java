package 序列化和深浅拷贝.深拷贝;


import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * @Author: Beer
 * @Date: 2019/8/7 12:34
 * @Description: 深拷贝之序列化
 */

class Teacher implements Serializable{
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

class Student implements Serializable {
    private String name;
    private Integer age;
    private Teacher teacher;

    public Student(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    public Student cloneObject() throws Exception{
        //首先获取内存流
        ByteOutputStream byteOutputStream =
                new ByteOutputStream();

        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(byteOutputStream);

        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream =
                new ByteArrayInputStream(byteOutputStream.getBytes());

        ObjectInputStream objectInputStream =
                new ObjectInputStream(byteArrayInputStream);

        return (Student) objectInputStream.readObject();
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
    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher("Beer","Java");
        Student student = new Student("Wine",20,teacher);
        Student stu = student.cloneObject();
        System.out.println(student);
        System.out.println(stu);
        System.out.println(teacher);
        System.out.println(stu.getTeacher());
        System.out.println(student.getName()==stu.getName());
        System.out.println(student.getAge() == stu.getAge());
    }
    /**
     * 结果：
     * 序列化和深浅拷贝.深拷贝.Student@2503dbd3
     * 序列化和深浅拷贝.深拷贝.Student@b4c966a
     * 序列化和深浅拷贝.深拷贝.Teacher@1d44bcfa
     * 序列化和深浅拷贝.深拷贝.Teacher@2f4d3709
     * false
     * false
     */
}
