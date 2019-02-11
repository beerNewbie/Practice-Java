package pers.hbc.foundation;

/**
 * 测试if单选择结构
 * @author胡博才
 */
public class TestIf {
    public static void main(String[] args) {
        double d = Math.random();//返回【0，1）之间的数
        System.out.println(d);

        int h = (int)(6*Math.random()+1);
        System.out.println(h);
        if(h<=3) {
            System.out.println("小");
        }

        System.out.println("#################");
//        //掷三个塞子试手气
//        int i = (int)(6*Math.random())+1;
//        int j = (int)(6*Math.random())+1;
//        int k = (int)(6*Math.random())+1;
//        int count = i+k+j;
//        if (count>15) {
//            System.out.println("手气炸天");
//        }
//        if (count<=15&&count>=10) {
//            System.out.println("手气一般");
//        }
//        if (count<10) {
//            System.out.println("手气背");
//        }

        //随机产生【0.0,4.0）之间半径，并根据 半径求圆的周长和面积
        double r = 4*Math.random();
        double area = Math.PI*Math.pow(r, 2);
        double circle = 2*Math.PI*r;
        System.out.println("圆的半径 ："+r);
        System.out.println("圆的面积："+area);
        System.out.println("圆的周长："+circle);
        if (area >= circle) {
            System.out.println("面积大于等于周长");
        }else {
            System.out.println("面积小于周长");
        }

    }
}
