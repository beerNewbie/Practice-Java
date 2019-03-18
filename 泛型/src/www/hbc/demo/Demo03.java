package www.hbc.demo;

/**
 * @Author: Beer
 * @Date: 2019/3/17 15:15
 * @Description:引用静态方法
 */
/**
interface IUtil<P,R> {
    public R switchPara(P p) ;
}
//引用静态方法
public class Demo03 {
    public static void main(String[] args) {
        IUtil<Integer,String> iu = String :: valueOf;
        String str = iu.switchPara(10000);
        System.out.println(str.length());
    }
}

interface IUtil<R> {
    public R switchPara();
}
//引用对象方法
public class Demo03 {
    public static void main(String[] args) {
        IUtil<String> iu = "hello" :: toUpperCase;
        System.out.println(iu.switchPara());
    }
}*/
interface IUtil<R,P> {
    public R compare(P p1,P p2);
}
public class Demo03 {
    public static void main(String[] args) {
        IUtil<Integer,String> iu = String :: compareTo;
        System.out.println(iu.compare("a","M"));
    }
}
