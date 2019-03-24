package www.hbc.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Beer
 * @Date: 2019/3/23 13:17
 * @Description:反射调用构造
 */
/**
//取得类中所有构造信息
class Person {
    public Person() {}
    public Person(String name) {}
    public Person(String name,int age) {}
}

public class TestDemo04 {
    public static void main(String[] args) {
        Class<?> cls = Person.class;
        //取得类中的全部构造
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
 */
/**
 * 结果：
 * public www.hbc.test.Person()
 * public www.hbc.test.Person(java.lang.String)
 * public www.hbc.test.Person(java.lang.String,int)
 */

//Class实例化对象
class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person[name:"+name+", age:"+age+"]";
    }
}
public class TestDemo04 {
    public static void main(String[] args) throws InstantiationException,IllegalAccessException,
            NoSuchMethodException,SecurityException,IllegalArgumentException,InvocationTargetException {
        Class<?> cls = Person.class;
        //System.out.println(cls.newInstance());//结果：Exception...
        //取得指定参数类型的构造方法对象
        Constructor<?> cons = cls.getConstructor(String.class,int.class);
        System.out.println(cons.newInstance("张三",20));//结果：Person[name:张三,age:20]
    }
}
