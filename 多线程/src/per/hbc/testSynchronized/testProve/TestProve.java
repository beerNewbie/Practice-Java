package per.hbc.testSynchronized.testProve;


/**
 * @Author: Beer
 * @Date: 2019/4/17 11:13
 * @Description: 证明锁的可重入与互斥
 */

class MyThread implements Runnable {
    @Override
    public void run() {
        fun1();
    }
    public synchronized void fun1() {
        if (Thread.currentThread().getName().equals("A")) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A线程进入fun1()方法。。。");
            fun2();
        }
    }
    public synchronized void fun2() {
        System.out.println(Thread.currentThread().getName()+"进入fun2()方法。。。");
    }
}
class MyThread1 implements Runnable {
    @Override
    public void run() {
        fun1();
        fun2();
    }
    public synchronized void fun1() {
        if (Thread.currentThread().getName().equals("A")) {
            while (true) {
                System.out.println("A运行中。。。");
            }
        }
    }
    public synchronized void fun2() {
        if (Thread.currentThread().getName().equals("B")) {
            System.out.println("B线程进入fun2()方法。。。");
        }else {
            System.out.println(Thread.currentThread().getName()+"进入fun2()方法。。。");
        }
    }
}
public class TestProve {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        Thread threadA = new Thread(myThread,"A");
        Thread threadB = new Thread(myThread,"B");
        threadA.start();
        threadB.start();
    }
}
/**
 * MyThread结果：
 *  A线程进入fun1()方法。。。
 *  A进入fun2()方法。。。
 *  --------------------
 *  MyThread1结果：
 *  A运行中。。。（死循环）
 *
 */