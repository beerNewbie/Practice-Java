package per.hbc.testSynchronized.testSynchornized;

/**
 * @Author: Beer
 * @Date: 2019/4/17 1:17
 * @Description: 能锁住：1.锁同一个对象；2.加static修饰
 */
class Syn1 {
    //任意时刻只有一个线程（同一个对象）能进入此方法
    //锁this对象Syn.class，（此时thread1、2、3调用对象不一样）
    public /*static*/ synchronized void fun() {
        System.out.println(Thread.currentThread().getName() +
                "开始运行。。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                "结束。。。");
    }
}

class MyThread1 implements Runnable {
    private Syn1 syn1;
    public MyThread1(Syn1 syn1) {
        this.syn1 = syn1;
    }
    @Override
    public void run() {
        this.syn1.fun();
    }
}

public class TestSuccess {
    public static void main(String[] args) {
        Syn1 syn1 = new Syn1();
        MyThread1 myThread = new MyThread1(syn1);
        Thread thread1 = new Thread(myThread, "线程1");
        Thread thread2 = new Thread(myThread, "线程2");
        Thread thread3 = new Thread(myThread, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
/**
 * 结束：
 * 线程1开始运行。。。
 * 线程1结束。。。
 * 线程3开始运行。。。
 * 线程3结束。。。
 * 线程2开始运行。。。
 * 线程2结束。。。
 */

