package pers.hbc.testJMM;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Beer
 * @Date: 2019/7/12 16:13
 * @Description: 使用原子类
 */
public class Test01 {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        atomicInteger.incrementAndGet();
                    }
                }
            });
            threads[i].start();
        }
        //确保for循环中的所有线程执行完毕
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(atomicInteger.get());//结果一定是1000
        /**
         * 并发场景下对于类似i++操作如何正确保证结果：
         * - 1.加锁
         * - 2.使用原子类（java.util.atomic包下的所有类一定是原子类--内部使用CAS保证原子性）
         */
    }
}
