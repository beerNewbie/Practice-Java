package 类与对象.testInnerClass;

/**
 * @Author: Beer
 * @Date: 2019/7/8 21:17
 * @Description:
 */
public class Test01 {
    public class Inner {
        {
            System.out.println("Inner Class");
        }
    }

    public static void main(String[] args) {
        System.out.println("Outter");

    }
}
