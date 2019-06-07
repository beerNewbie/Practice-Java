package 类与对象.testConstruct;

/**
 * @Author: Beer
 * @Date: 2019/6/8 1:48
 * @Description: 构造方法是否一定比类中进行实例化快
 *
 * 先进入构造方法执行父类构造方法，再去实例化Y,最后执行构造块中方法
 */
class X extends Y{
    Y y = new Y();
    public X() {
        System.out.print("X");
    }
}

class Y {
    public Y() {
        System.out.print("Y");
    }
}

public class Z extends X{
    Y y = new Y();
    public Z() {
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new Z();//YYXYZ
    }
}
