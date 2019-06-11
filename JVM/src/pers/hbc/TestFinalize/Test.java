package pers.hbc.TestFinalize;

/**
 * @Author: Beer
 * @Date: 2019/6/11 21:11
 * @Description: 对象的自我拯救
 */
public class Test {
    private static Test test;
    public void isAlive() {
        if (test != null) {
            System.out.println("对象存活");
        }
    }
    @Override
    protected void finalize() throws Throwable {//JVM调用的
        super.finalize();
        System.out.println("执行finalize()");
        test = this;
    }
    public static void main(String[] args) {
        test = new Test();
        test = null;
        System.gc();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (test != null) {
            test.isAlive();
        }else {
            System.out.println("对象已死");
        }
        test = null;
        System.gc();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (test != null) {
            test.isAlive();
        }else {
            System.out.println("对象已死");
        }
    }
    /**
     * 结果：
     * 执行finalize()
     * 对象存活
     * 对象已死
     *
     */
}
