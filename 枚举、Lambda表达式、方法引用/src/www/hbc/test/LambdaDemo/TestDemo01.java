package www.hbc.test.LambdaDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/21 9:11
 * @Description:传统面向对象开发与函数式编程
 * 要想使用函数式编程有一个前提：接口必须只有一个方法，如果有两个方法，则无法使用函数式编程。如果现在某
 * 个接口就是为了函数式编程而生的，最好在定义时就让其只能够定义一个方法，所以有了一个新的注解：
 * @FunctionalInterface
 */
@FunctionalInterface
interface IMessage {
    void print();
}
public class TestDemo01 {
    public static void main(String[] args) {
        IMessage message = new IMessage() {//匿名内部类
            @Override
            public void print() {
                System.out.println("Hello Word");
            }
        };
        //使用函数式编程
        IMessage message1 = () -> {
            System.out.println("Hello everyone");
            System.out.println("Hello everyone");
            System.out.println("Hello everyone");
        };
        message1.print();
        message.print();
    }
}
