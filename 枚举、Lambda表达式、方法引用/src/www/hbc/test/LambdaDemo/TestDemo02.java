package www.hbc.test.LambdaDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/21 9:41
 * @Description:
 */
@FunctionalInterface
interface IMath {
    int add(int x,int y);
}
public class TestDemo02 {
    public static void main(String[] args) {
        IMath msg = (p1,p2) -> p1 + p2;
        System.out.println(msg.add(10,20));
    }
}
