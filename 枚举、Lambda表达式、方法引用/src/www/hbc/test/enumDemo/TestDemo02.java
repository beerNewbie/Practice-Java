package www.hbc.test.enumDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/20 13:27
 * @Description:在枚举中定义更多的结构
 */

enum Color1 {
    RED("红"),GREEN("绿"),BLUE("蓝");//如果定义很多内容枚举对象必须放在第一行
    private String title;
    private Color1(String title) {
        this.title = title;
    }
    public String toString() {
        return this.title;
    }
}
public class TestDemo02 {
    public static void main(String[] args) {
        System.out.println(Color1.BLUE);
    }
}
/**
 * 结果：蓝
 */
