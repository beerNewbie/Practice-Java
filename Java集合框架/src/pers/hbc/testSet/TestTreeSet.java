package pers.hbc.testSet;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Beer
 * @Date: 2019/4/11 8:54
 * @Description:
 */
class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

   @Override
    public int compareTo(Person o) {
        if (this.age > o.age) {
            return 1;
        }else if (this.age < o.age) {
            return -1;
        }else {
            return this.name.compareTo(o.name);
        }
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestTreeSet {
    public static void main(String[] args) {
        Set<Person> perSet = new TreeSet<>();
        perSet.add(new Person("王五",23));
        perSet.add(new Person("张三",20));
        perSet.add(new Person("李四",22));
        System.out.println(perSet);
        System.out.println(perSet.contains(new Person("张五",20)));
        System.out.println(perSet.remove(new Person("张三",20)));
        System.out.println(perSet);
        Set<String> set = new TreeSet<>();
        set.add("a");
        set.add("A");
        set.add("F");
        System.out.println(set);
        System.out.println(set.remove("F"));
        System.out.println(set);
    }
}
/**
 * 结果：
 * [Person{name='张三', age=20}, Person{name='李四', age=22}, Person{name='王五', age=23}]
 * false
 * true
 * [Person{name='李四', age=22}, Person{name='王五', age=23}]
 *
 * [A, F, a]
 * true
 * [A, a]
 */
