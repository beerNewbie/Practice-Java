package pers.hbc.testJMM;

/**
 * @Author: Beer
 * @Date: 2019/7/12 14:52
 * @Description: Java内存模型
 */
public class Test {
    private static volatile int num = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        num++;
                    }
                }
            });
            threads[i].start();
        }
        //确保for循环中的所有线程执行完毕
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(num);//结果有可能不是1000
        /**
         * 因为JMM规定所有变量必须存储主内存中。每条线程都有
         * 自己的工作内存，线程的工作内存中保存了该线程使用
         * 到的变量的主内存副本。线程对变量的所有操作（读取、
         * 赋值等）都必须在工作内存中进行，不能直接读取主内
         * 存中的变量。不同线程之间无法直接访问彼此的工作内
         * 存变量，线程变量值的传递均需要通过主内存来完成。
         * 即主内存与工作内存存在延迟
         */
    }
}
