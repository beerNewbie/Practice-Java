package 数据类型方面;


/**
 * @Author: Beer
 * @Date: 2019/8/9 15:20
 * @Description:
 */

public class TestIf {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 1;
        int n3 = 1;
        //if (n1==n2==n3)//这是明显错误的，int类型怎么能和boolean进行等于比较呢
          if (n1 == n2 == false) {
              System.out.println(false);
          }
        System.out.println(true);//true
    }
}
