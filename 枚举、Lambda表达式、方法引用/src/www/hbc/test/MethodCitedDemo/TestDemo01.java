package www.hbc.test.MethodCitedDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/21 18:37
 * @Description:引用静态方法
 */
@FunctionalInterface
interface IUtil<P,R> {
    public abstract R switchPara(P p) ;
}
public class TestDemo01 {
    public static void main(String[] args) {
        IUtil<Integer,String> iu = String :: valueOf;//进行方法引用
        String str = iu.switchPara(100);
        System.out.println(str.length());//3

    }
}
