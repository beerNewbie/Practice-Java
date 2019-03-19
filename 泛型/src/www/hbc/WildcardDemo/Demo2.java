package www.hbc.WildcardDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/19 13:01
 * @Description:泛型上限
 * ? extends 类表示泛型上限，类与方法均可使用
 */
class Message2<T extends Number> {
    private T message;

    public T getMessage() {
        return message;
    }
    public void setMessage(T message) {
        this.message = message;
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Message2<Integer> message2 = new Message2<>();
        message2.setMessage(200);
        fun(message2);
    }
    //还是无法确定类型，所以无法修改
    public static void fun(Message2<? extends Number> temp) {
        //temp.setMessage(200);无法修改
        System.out.println(temp.getMessage());
    }
}
