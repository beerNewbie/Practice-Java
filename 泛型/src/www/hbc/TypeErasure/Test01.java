package www.hbc.TypeErasure;

/**
 * @Author: Beer
 * @Date: 2019/3/20 11:17
 * @Description:
 */
class MyClass<T> {
    private T msg;
    public T getMsg() {
        return msg;
    }
    public void setMsg(T msg) {
        this.msg = msg;
    }
}
public class Test01 {
    public static void main(String[] args) {
        MyClass<String> myClass1 = new MyClass<>();
        MyClass<Integer> myClass2 = new MyClass<>();
        System.out.println(myClass1.getClass() == myClass2.getClass());
    }
}
/**
 结果：true
 是因为 MyClass<String> 和 MyClass<Integer> 在 JVM 中的 Class 都是
 MyClass.class 。
 */