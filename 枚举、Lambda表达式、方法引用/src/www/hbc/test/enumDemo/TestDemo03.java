package www.hbc.test.enumDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/20 13:38
 * @Description:枚举实现接口
 */

interface IColor {
    String getColor();
}
enum Color2 implements IColor {
    RED("红色"),BLUE("蓝色"),GREEN("绿色");
    private String title;
    private Color2(String title) {
        this.title = title;
    }
    public String toString() {
        return this.title;
    }
    @Override
    public String getColor() {
        return this.title;
    }
}
public class TestDemo03 {
    public static void main(String[] args) {
        IColor iColor = Color2.BLUE;
        System.out.println(iColor.getColor());
    }
}
