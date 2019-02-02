interface IMessage {
    void getMessage();
}
class Message implements IMessage {
    public String toString() {
        return "I am a student.";
    }
    public void getMessage() {
        System.out.println("hello");
    }
}
public class Test {
    public static void main(String[] args) {
        IMessage msg = new Message();//子类向父接口转型
        Object obj = msg;//接口向Object转型
        System.out.println(obj);
        IMessage temp = (IMessage) obj;//强制类型转换
        temp.getMessage();
    }
}
