package www.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/24 19:50
 * @Description:通过反射调用setter、getter方法
 */

import java.lang.reflect.Method;

/**
 * 取得特定普通方法;
 * public Method getMethod(String name, Class<?>... parameterTypes)
 */
class Person2 {
    private String name;
    private int age;
    public Person2() {}
    public Person2(String name,int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person2[name:"+name+", age:"+age+"]";
    }
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
public class TestDemo06 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("www.hbc.test.Person2");
        //任何时候调用类中的普通方法都必须有实例化对象
        Object obj = cls.newInstance();
        //取得setName这个方法的实例化对象，设置方法名称与参数类型
        Method setMethod = cls.getMethod("setName",String.class);
        //随后需要通过Method类对象调用指定的方法，调用方法需要有实例化对象
        //同时传入参数
        setMethod.invoke(obj,"张三");//相当于Person对象.setName("张三")
        Method getMethod = cls.getMethod("getName");
        Object result = getMethod.invoke(obj);//相当于Person对象.getName();
        System.out.println(result);//结果：张三
    }
}
