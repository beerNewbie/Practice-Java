package www.hbc.test.MethodCitedDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/22 0:27
 * @Description:引用构造方法
 */
class Person {
    private String name;
    private int age;

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person[name:" + name +
                ", age:" + age +"]";
    }
}

@FunctionalInterface
interface MyUtil<R,PN,PA> {
    R createPerson(PN p1,PA p2);
}

public class TestDemo04 {
    public static void main(String[] args) {
        MyUtil<Person, String, Integer> myUtil = Person :: new;
        System.out.println(myUtil.createPerson("张三",20));
    }
}
