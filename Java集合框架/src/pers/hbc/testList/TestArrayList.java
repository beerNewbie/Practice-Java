package pers.hbc.testList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Beer
 * @Date: 2019/4/9 22:50
 * @Description:
 */
class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //重写equals（）方法
   /* public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }else if (obj == null) {
            return false;//非空性原则
        }else if (!(obj instanceof Person)) {
            return false;
        }//如何比较对象具体属性？？
        //向下转型还原为Person对象
        Person per = (Person) obj;
        return this.name.equals(per.getName()) && this.age.equals(per.age);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class TestArrayList {
    public static void main(String[] args) {
        List<Person> perList = new ArrayList<>();
        perList.add(new Person("张三",20));
        perList.add(new Person("张五",19));
        perList.add(new Person("王六",18));
        System.out.println(perList);
        System.out.println(perList.contains(new Person("张五",19)));
        System.out.println(perList.remove(new Person("张五",19)));
        System.out.println(perList);

    }
}
/**
 * 结果：
 * [Person{name='张三', age=20}, Person{name='张五', age=19}, Person{name='王六', age=18}]
 * true
 * true
 * [Person{name='张三', age=20}, Person{name='王六', age=18}]
 */
