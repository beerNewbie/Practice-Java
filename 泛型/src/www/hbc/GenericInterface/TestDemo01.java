package www.hbc.GenericInterface;

/**
 * @Author: Beer
 * @Date: 2019/3/20 9:36
 * @Description:子类定义时继续使用泛型
 */
interface Imessage<T> {
    void print(T t) ;

}
class MessageImpl<T> implements Imessage<T> {
    public void print(T t) {
        System.out.println(t);
    }
}
public class TestDemo01 {
    public static void main(String[] args) {
        Imessage<String> message = new MessageImpl();//向下转型
        message.print("Hello world");
    }
}
