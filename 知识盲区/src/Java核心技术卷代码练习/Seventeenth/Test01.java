package Java核心技术卷代码练习.Seventeenth;


/**
 * @Author: Beer
 * @Date: 2019/8/8 0:50
 * @Description: 利用堆栈轨迹分析递归阶乘函数的堆栈情况
 */

public class Test01 {
    public static void main(String[] args) {
        factorial(5);
    }

    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames) {
            System.out.println(f);
        }
        int r;
        if (n <= 1) {
            r = 1;
        } else {
            r = n * factorial(n - 1);
        }
        System.out.println("return:" + r);
        return r;
    }
    /**
     * 结果：
     * factorial(5):
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:17)
     * Java核心技术卷代码练习.Seventeenth.Test01.main(Test01.java:12)
     * factorial(4):
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:17)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.main(Test01.java:12)
     * factorial(3):
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:17)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.main(Test01.java:12)
     * factorial(2):
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:17)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.main(Test01.java:12)
     * factorial(1):
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:17)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.factorial(Test01.java:26)
     * Java核心技术卷代码练习.Seventeenth.Test01.main(Test01.java:12)
     * return:1
     * return:2
     * return:6
     * return:24
     * return:120
     */
}
