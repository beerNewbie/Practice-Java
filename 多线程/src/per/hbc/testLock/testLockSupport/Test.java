package per.hbc.testLock.testLockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author: Beer
 * @Date: 2019/5/20 12:09
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println("当前线程阻塞");
        });
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(thread);
    }
}
