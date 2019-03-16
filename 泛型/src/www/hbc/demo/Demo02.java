package www.hbc.demo;

/**
 * @Author: Beer
 * @Date: 2019/3/15 22:54
 * @Description:泛型方法
 */
class MyClass<T> {
    public void testMethod01(T t) {
        System.out.println(t);
    }
    public <E> E testMethod2(E e) {//如果在一个泛型类中存在泛型方法，那么两者的类型参数最好不要同名
        return e;
    }
}

public class Demo02 {
    public static void main(String[] args) {
        MyClass<String> myClass = new MyClass<>();
        myClass.testMethod01("泛型类");
        Integer i = myClass.testMethod2(666);
        System.out.println(i);
    }

}
