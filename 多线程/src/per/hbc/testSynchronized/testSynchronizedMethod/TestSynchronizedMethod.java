package per.hbc.testSynchronized.testSynchronizedMethod;

/**
 * @Author: Beer
 * @Date: 2019/4/17 0:37
 * @Description:
 */

class MyThread implements Runnable {
    private int tickets = 100;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            sale();
        }
    }
    //此时只有一个线程能进入此方法
    //隐式锁对象this
    public synchronized void sale() {
        if (this.tickets > 0) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    "：还剩票" + this.tickets-- + "张");
        }
    }
}
public class TestSynchronizedMethod {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread, "客户1");
        Thread thread2 = new Thread(myThread, "客户2");
        Thread thread3 = new Thread(myThread, "客户3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
