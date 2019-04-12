package pers.hbc.testSet;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Beer
 * @Date: 2019/4/12 23:35
 * @Description: 使用Comparator接口
 */
class Person1 {
    private String name;
    private Integer age;

    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class AgeComparator implements Comparator<Person1> {
    @Override
    public int compare(Person1 o1, Person1 o2) {
        return o1.getAge() - o2.getAge();
    }
}

public class TestComparator {
    public static void main(String[] args) {
        Set<Person1> set = new TreeSet<Person1>(new AgeComparator());
        set.add(new Person1("张三", 20));
        set.add(new Person1("李四", 25));
        set.add(new Person1("王五", 18));
        System.out.println(set);
    }
}
/**
 * 结果：
 * [Person1{name='王五', age=18}, Person1{name='张三', age=20}, Person1{name='李四', age=25}]
 */
