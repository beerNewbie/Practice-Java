package per.hbc.testProducerAndConsumer.methodTest;

/**
 * @Author: Beer
 * @Date: 2019/4/29 23:04
 * @Description: 使用两个线程，输出12A34B56C...5152Z
 */
class Print {
    private boolean flag = false;
    private int count = 1;

    public synchronized void printNum() {
        if (flag == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(count * 2 - 1);
        System.out.print(count * 2);
        //
        flag = true;
        notify();
    }

    public synchronized void printLetter() {
        if (flag == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print((char) ('A' + count - 1));//字符型+整型会自动转型为整型，因此要强制类型转换
        flag = false;
        count++;
        notify();
    }
}

public class TestPrintNum {
    public static void main(String[] args) {
        Print print = new Print();

        new Thread(() -> {
            //一个线程调用26次打印方法
            for (int i = 0; i < 26; i++) {
                print.printNum();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                print.printLetter();
            }
        }).start();
    }
}
/**
 *结果：12A34B56C78D910E1112F1314G1516H1718I1920J2122K2324L2526M2728N2930O3132P3334Q3536R3738S3940T4142U4344V4546W4748X4950Y5152Z
 *
 */
