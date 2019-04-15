package per.hbc.TestCommentMethods.testjoinMethod;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Beer
 * @Date: 2019/4/15 14:32
 * @Description: join()
 */
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("子线程开始执行。。。");
        Test.printTime();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Test.printTime();
        System.out.println("子线程执行结束。。。");
    }
}

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主方法开始。。。");
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        thread.join();
        System.out.println("主方法结束。。。");
    }

    public static void printTime() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String str = dateFormat.format(date);
        System.out.println(str);
    }
}
/**
 结果：
 主方法开始。。。
 子线程开始执行。。。
 2019-04-15 14:45:12
 2019-04-15 14:45:13
 子线程执行结束。。。
 主方法结束。。。
 */