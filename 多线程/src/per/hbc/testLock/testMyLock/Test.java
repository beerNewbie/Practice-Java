package per.hbc.testLock.testMyLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: Beer
 * @Date: 2019/5/13 11:22
 * @Description: 实现自己的锁
 */
class MyLock implements Lock {
    private Syn sync = new Syn();

    static class Syn extends AbstractQueuedSynchronizer {
        //规定同步状态为1
        @Override
        protected boolean tryAcquire(int arg) {
            if (arg != 1) {
                throw new RuntimeException("Illegal arg");
            }
            if (compareAndSetState(0, 1)) {
                //当前线程成功获取到锁
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    //***************Lock接口方法*********************
    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, time);
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}

class MyThread implements Runnable {
    Lock lock = new MyLock();
    @Override
    public void run() {
        try {
            lock.lock();
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(myThread);
            thread.start();
        }
    }
}
/**
 * 锁住了
 * Debug:
 * "Attach Listener"@555: RUNNING
 * "DestroyJavaVM"@543 in group "main": RUNNING
 * "Finalizer"@557: WAIT
 * "Reference Handler"@558: WAIT
 * "Signal Dispatcher"@556: RUNNING
 * "Thread-2"@546 in group "main": SLEEPING
 * "Thread-3"@547 in group "main": WAIT
 * "Thread-4"@548 in group "main": WAIT
 * "Thread-5"@550 in group "main": WAIT
 * "Thread-6"@551 in group "main": WAIT
 * "Thread-7"@552 in group "main": WAIT
 * "Thread-8"@553 in group "main": WAIT
 * "Thread-9"@554 in group "main": WAIT
 */
