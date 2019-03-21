package www.hbc.test.MethodCitedDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/22 0:22
 * @Description:引用类中普通方法
 */
interface IUtil3<R,P> {
    R compare(P p1, P p2);
}
public class TestDemo03 {
    public static void main(String[] args) {
        IUtil3<Integer,String> iu = String :: compareTo;
        System.out.println(iu.compare("a","A"));//32
    }
}
