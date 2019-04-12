package pers.hbc.testSet;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Beer
 * @Date: 2019/4/13 0:53
 * @Description: hashCode与equals
 */

/**
 * 如果两个对象equals，那么它们的hashCode必然相等，
 * 但是hashCode相等，equals不一定相等。
 * 对象判断必须两个方法equals()、hashCode()返回值都相同才判断为
 */
class Person2 implements Comparable<Person2>{//public interface Comparable<T> {}不要忘记<>
    private String name;
    private Integer age;
   /* public boolean equals(Object o) {
        if (this == o) {
           return true;
        }
        else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person2 person2 = (Person2)o;
        return this.age == ((Person2) o).age && this.name.equals(((Person2) o).name);
    }
    public int hashCode() {//hash码int 类型
        return Objects.hash(name,age);
    }*/


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return Objects.equals(name, person2.name) &&
                Objects.equals(age, person2.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    @Override
    public int compareTo(Person2 o) {
        if (this.age > o.age) {
            return 1;
        }else if (this.age < o.age) {
            return -1;
        }else {
            return this.name.compareTo(o.name);
        }
    }
    public Person2(String name, Integer age) {
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
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestHashCodeAndEquals {
    public static void main(String[] args) {
        Set<Person2> set = new TreeSet<>();
        set.add(new Person2("张三",38));
        set.add(new Person2("王五",28));
        set.add(new Person2("张三",38));
        set.add(new Person2("王六",20));
        System.out.println(set);
    }
}
/**
 * 结果：//hashCode与equals缺少任一个都不会减少
 * [Person2{name='王六', age=20}, Person2{name='王五', age=28}, Person2{name='张三', age=38}]
 *
 */