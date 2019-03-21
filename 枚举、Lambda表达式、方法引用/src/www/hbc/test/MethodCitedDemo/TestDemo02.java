package www.hbc.test.MethodCitedDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/22 0:17
 * @Description:引用对象方法
 */
@FunctionalInterface
interface IUtil2<R> {
    R switchPara();
}
public class TestDemo02 {
    public static void main(String[] args) {
        IUtil2<String> iu = "hello world" :: toUpperCase;
        System.out.println(iu.switchPara());//HELLO WORLD
    }
}
