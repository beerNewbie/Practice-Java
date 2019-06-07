package 数据类型方面;

/**
 * @Author: Beer
 * @Date: 2019/6/8 1:42
 * @Description:
 */
public class TestInt {
    private int count;

    public static void main(String[] args) {
        TestInt test = new TestInt(88);
        System.out.println(test.count);//88
    }
    TestInt(int i) {
        count = i;
    }
}
