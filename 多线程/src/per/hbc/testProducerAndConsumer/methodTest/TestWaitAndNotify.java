package per.hbc.testProducerAndConsumer.methodTest;

/**
 * @Author: Beer
 * @Date: 2019/4/27 21:20
 * @Description:
 */
class MyThread implements Runnable {
    private Object object;
    private boolean flag;

    public MyThread(Object object, boolean flag) {
        this.object = object;
        this.flag = flag;
    }

    public void waitMethod() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " begin...");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end...");
        }
    }

    public void notifyMethod() {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " start...");
           // object.notify();
            object.notifyAll();
            System.out.println(Thread.currentThread().getName() + " end...");
        }
    }

    @Override
    public void run() {
        if (flag) {
            waitMethod();
        } else {
            notifyMethod();
        }
    }
}

public class TestWaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        MyThread mt1 = new MyThread(obj, true);
        MyThread mt2 = new MyThread(obj, false);
        for (int i = 0; i < 10; i++) {
            Thread waitThread = new Thread(mt1, "WaitThread" + i);
            waitThread.start();
        }
        /*多个线程唤醒是随机的（源代码注释）：The choice is arbitrary(任意的) and occurs at
      the discretion（判定） of the implementation.（看版本）*/
        Thread notifyThread = new Thread(mt2, "NotifyThread");
        Thread.sleep(1000);
        notifyThread.start();
    }
}
/**
 * 结果：
 * WaitThread begin...
 * NotifyThread start...
 * NotifyThread end...
 * WaitThread end...
 *
 *
 * 多个线程等待唤醒结果：
 * WaitThread0 begin...
 * WaitThread1 begin...
 * WaitThread2 begin...
 * WaitThread3 begin...
 * WaitThread4 begin...
 * WaitThread5 begin...
 * WaitThread6 begin...
 * WaitThread7 begin...
 * WaitThread8 begin...
 * WaitThread9 begin...
 * NotifyThread start...
 * NotifyThread end...
 * WaitThread0 end...
 */