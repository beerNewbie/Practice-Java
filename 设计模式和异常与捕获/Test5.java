/**
 * 自定义异常类：
 *   自定义异常类可以继承两种父类：Exception、RuntimeException。
 */
class AddException extends Exception {
    public AddException(String msg) {
        super(msg);
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        int num1 = 30;
        int num2 = 30;
        if (num1+num2 == 60) {
            throw new AddException("错误的操作");
        }
    }
}
