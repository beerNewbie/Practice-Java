package 数据类型方面;

/**
 * @Author: Beer
 * @Date: 2019/6/16 2:10
 * @Description: 下列递归中3乘了几次？4次
 *  3*f(14,6)
 *  3*f(8,3)
 *  3*f(2,1)
 *  3*F(-4,0)
 */
public class TestRecursion {
    public static void main(String[] args) {
        System.out.println(foo(20,13));//81
    }

    public static int foo(int n, int m) {
        if (n <= 0 || m <= 0) {
            return 1;
        }
        return 3*foo(n-6,m/2);
    }
}
