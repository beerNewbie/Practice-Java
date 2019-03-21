package www.hbc.test.enumDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/20 13:07
 * @Description:取得所有枚举数据
 */
enum Color {
    RED,YELLOW,BLUE
}
public class TestDemo01 {
    public static void main(String[] args) {
        for (Color temp : Color.values()) {
            System.out.println(temp.ordinal()+"="+temp.name());
        }
    }
}
/**
 * 结果：
 * 0=RED
 * 1=YELLOW
 * 2=BLUE
 */
