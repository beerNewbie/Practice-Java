package www.hbc.WildcardDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/19 13:31
 * @Description:设置泛型下限
 */
class Message3<T> {
    private T message;
    public T getMessage() {
        return message;
    }

    public void setMessage(T message){
        this.message = message;
    }

}
public class Demo03 {
    public static void main(String[] args) {
        Message3<Integer> message3 = new Message3<>();
        message3.setMessage(300);
        fun(message3);
    }
    public static void fun(Message3<? super Integer> temp) {
        temp.setMessage(600);//此时可以修改
        System.out.println(temp.getMessage());//结果是：600
    }
}
