/**
 * @Author: Beer
 * @Date: 2019/7/15 14:19
 * @Description:  字符串性能测试比较
 */
public class Main {
    private static String testStringAdd() {
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += i;
        }
        return s;
    }

    private static String testStringBilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int iterations = 100;
        int groups = 5;
        System.out.println("testStringAdd:");
        for (int i = 0; i < groups; i++) {
            long t1 = System.nanoTime();
            for (int j = 0; j < iterations; j++) {
                testStringAdd();
            }
            long t2 = System.nanoTime();
            System.out.println("第" + (i + 1) + "次实验耗时" + (t2 - t1) + "纳秒");
        }
        System.out.println("testStringBuilder:");
        for (int i = 0; i < groups; i++) {
            long t1 = System.nanoTime();
            for (int j = 0; j < iterations; j++) {
                testStringBilder();
            }
            long t2 = System.nanoTime();
            System.out.println("第" + (i + 1) + "次实验耗时" + (t2 - t1) + "纳秒");
        }
    }
    /**
     * 未优化前交换位置结果
     * add:273383
     * append:12247
     * add:32790
     * append:372938
     * 可能影响性能的因素：
     *      执行时间过短；
     *      次数太少；
     *      编译器的自我优化（AOT编译器/JIT编译器）
     *      预热
     *
     * 结果：
     * testStringAdd:
     * 第1次实验耗时2926616纳秒
     * 第2次实验耗时436938纳秒
     * 第3次实验耗时336987纳秒
     * 第4次实验耗时282074纳秒
     * 第5次实验耗时209778纳秒
     * testStringBuilder:
     * 第1次实验耗时109037纳秒
     * 第2次实验耗时107457纳秒
     * 第3次实验耗时108246纳秒
     * 第4次实验耗时121679纳秒
     * 第5次实验耗时109432纳秒
     */
}
