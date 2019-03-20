package www.hbc.GenericInterface;

/**
 * @Author: Beer
 * @Date: 2019/3/20 9:59
 * @Description:
 */
interface IMessage<T> {
    void print(T t);
}
class MessageImpl2 implements IMessage<String> {
    public void print(String str) {
        System.out.println(str);
    }
}
public class TestDemo02 {
    public static void main(String[] args) {
        IMessage<String> messageImpl2 = new MessageImpl2();
        messageImpl2.print("Hello world");
    }
}
