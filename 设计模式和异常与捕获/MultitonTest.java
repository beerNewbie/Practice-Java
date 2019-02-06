//多例设计模式
/**
 * 1. 构造方法私有化。
 * 2. 类内部一定会提供一个static方法用于取得实例化对象
 */
//定义一个性别的多例类
class Sex {
    private String title;
    public final static int FEMALE_FLAG = 1;
    public final static int MALE_FLAG = 2;
    private final static Sex MALE = new Sex("男");
    private final static Sex FEMALE = new Sex("女");
    private Sex(String title) {
        this.title = title;
    }
    public static Sex getInstance(int flag) {
        switch(flag) {
            case FEMALE_FLAG:
                return FEMALE;
            case MALE_FLAG:
                return MALE;
            default:
                return null;
        }
    }
    public String toString() {
        return this.title;
    }
}
public class MultitonTest {
    public static void main(String[] args) {
        Sex male = Sex.getInstance(Sex.MALE_FLAG);
        System.out.println(male);
    }
}
