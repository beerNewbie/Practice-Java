package www.hbc.test;

import java.lang.reflect.Method;

/**
 * @Author: Beer
 * @Date: 2019/3/24 19:31
 * @Description:取得一个类的全部普通方法
 * public Method[] getMethods() throws SecurityException
 */
class Person1 {
    private String name;
    private int age;
    public Person1() {}
    public Person1(String name,int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person1[name:" + name +
                ", age:" + age + "]";
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
public class TestDemo05 {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Person1.class;
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
/**
 * 结果：
 * public java.lang.String www.hbc.test.Person1.toString()
 * public java.lang.String www.hbc.test.Person1.getName()
 * public void www.hbc.test.Person1.setName(java.lang.String)
 * public int www.hbc.test.Person1.getAge()
 * public void www.hbc.test.Person1.setAge(int)
 * public final void java.lang.Object.wait() throws java.lang.InterruptedException
 * public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
 * public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
 * public boolean java.lang.Object.equals(java.lang.Object)
 * public native int java.lang.Object.hashCode()
 * public final native java.lang.Class java.lang.Object.getClass()
 * public final native void java.lang.Object.notify()
 * public final native void java.lang.Object.notifyAll()
 */
