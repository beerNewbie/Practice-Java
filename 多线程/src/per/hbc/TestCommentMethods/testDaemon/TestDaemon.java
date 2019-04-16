package per.hbc.TestCommentMethods.testDaemon;

/**
 * @Author: Beer
 * @Date: 2019/4/16 16:18
 * @Description:
 */
class MyThread implements Runnable {
    @Override
    public void run() {
        int i = 1;
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "是否是守护线程："
                        + Thread.currentThread().isDaemon());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "结束。。。");
                return;
            }
        }
    }
}
public class TestDaemon {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始。。。");
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt, "线程1(守护线程)");
        Thread thread2 = new Thread(mt, "线程2(用户线程)");
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread2.interrupt();//注意interrupt、interrupted与IsInterrupted的不同
        System.out.println("主线程结束。。。");//main方法线程并不一定是最后一个退出的线程
    }
}
