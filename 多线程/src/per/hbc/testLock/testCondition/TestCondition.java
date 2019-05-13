package per.hbc.testLock.testCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Beer
 * @Date: 2019/5/13 17:55
 * @Description:
 */
public class TestCondition {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() ->{
                try {
                    lock.lock();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}
