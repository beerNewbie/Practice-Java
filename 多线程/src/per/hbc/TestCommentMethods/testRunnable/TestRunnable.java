package per.hbc.TestCommentMethods.testRunnable;

/**
 * @Author: Beer
 * @Date: 2019/4/15 13:44
 * @Description:
 */
class MyThread implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() +
                    "还剩票：" + tickets--);
        }
    }
}

public class TestRunnable {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"线程1");
        Thread thread2 = new Thread(myThread,"线程2");
        Thread thread3 = new Thread(myThread,"线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
