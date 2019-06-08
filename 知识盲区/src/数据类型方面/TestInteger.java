package 数据类型方面;

/**
 * @Author: Beer
 * @Date: 2019/6/8 17:50
 * @Description:
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer i1 = 58;
        Integer i5 = 58;
        int i2 = 58;
        Integer i3 = Integer.valueOf(58);
        int i4 = Integer.parseInt("58");
        Integer i6 = new Integer(58);
        Integer i7 = new Integer(58);
        System.out.println(i1==i2);//true
        System.out.println(i2 == i4);//true
        System.out.println(i1 == i6);//false
        System.out.println(i2 == i6);//true
        System.out.println(i1 == i4);//true
        System.out.println(i3 == i1);//true
        System.out.println(i3 == i6);//false
        System.out.println(i6 == i4);//true
        System.out.println(i3 == i4);//true
        System.out.println(i6 == i7);//false
        System.out.println(i1 == i5);//true
    }
}
