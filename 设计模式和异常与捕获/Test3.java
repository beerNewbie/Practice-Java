/**
 * throw关键字:
 *     用在方法体代码中，表示人为进行异常的抛出。如果希望自己产生异常类对
 *     象而非由JVM产生，就可以在代码块中使用throw来抛出异常(一般与分支语
 *     句搭配使用来抛出自定义异常)
 * 解释throw和throws的区别
 *     1. throw用于方法内部，主要表示手工异常抛出。
 *     2. throws主要在方法声明上使用，明确告诉用户本方法可能产生的异常，同时该方法可能不处理此异常。
 */
//使用throw产生异常类对象
public class Test {
    public static void main(String[] args) {
        try {
            throw new Exception("抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
