package 数据类型方面;

/**
 * @Author: Beer
 * @Date: 2019/7/2 22:54
 * @Description: 输出中的表达式的先后顺序
 *
 *      在遇到 ""（字符串）之前按照原有的计算顺序进行计算
 */
public class TestOut {
    public static void main(String[] args) {
        int a = 20;
        int b = 5;
        System.out.println(a + b + "" + (a + b) + b);//25255
    }
}
