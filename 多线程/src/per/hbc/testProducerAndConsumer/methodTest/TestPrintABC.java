package per.hbc.testProducerAndConsumer.methodTest;

/**
 * @Author: Beer
 * @Date: 2019/4/29 23:53
 * @Description: 通过3个线程ABC打印5遍ABC即：ABCABCABCABCABC
 */
class PrintABC {
    private int flag = 1;//控制打印顺序
    private int count = 0;//控制打印次数

    public int getCount() {
        return count;
    }

    public synchronized void printA() {
        while (flag != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("A");
        count++;
        flag = 2;
        notifyAll();
    }
    public synchronized void printB() {
        while (flag != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("B");
        count++;
        flag = 3;
        notifyAll();
    }
    public synchronized void printC() {
        while (flag != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("C");
        count++;
        flag = 1;
        notifyAll();
    }
}
class MyThread1 implements Runnable{
    private PrintABC print;
    public  MyThread1(PrintABC print) {
        this.print = print;
    }
    @Override
    public void run() {
        while (print.getCount() < 13) {//此时得到的count是A的
            if (Thread.currentThread().getName().equals("A")) {
                print.printA();
            }else if (Thread.currentThread().getName().equals("B")) {
                print.printB();
            }else if (Thread.currentThread().getName().equals("C")) {
                print.printC();
            }
        }
    }
}

public class TestPrintABC {
    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();
        MyThread1 mt = new MyThread1(printABC);
        new Thread(mt,"A").start();
        new Thread(mt,"B").start();
        new Thread(mt,"C").start();
    }
}
/**
 结果：ABCABCABCABCABC
 */