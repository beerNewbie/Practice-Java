package pers.hbc.foundation;

/**
 * 逻辑运算符
 * @author hbc
 */
public class TestOpreator {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1&b2);//false
        System.out.println(b1|b2);//true
        System.out.println(b1^b2);//true
        System.out.println(!b1);//false
        System.out.println("**********");
        //短路
        boolean b3 = 1>2&&2<(3/0);//短路与，第一个操作数为false则不需要管后面的操作数
        System.out.println(b3);
        boolean b4 = 1<2||2<(3/0);
        System.out.println(b4);
    }
}
