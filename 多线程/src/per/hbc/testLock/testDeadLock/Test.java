package per.hbc.testLock.testDeadLock;

/**
 * @Author: Beer
 * @Date: 2019/5/20 12:27
 * @Description:
 */
class Customer {}
class Businessman {}

public class Test {
    private static Customer customer = new Customer();
    private static Businessman businessman = new Businessman();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
           synchronized(customer) {
               System.out.println("顾客：先给东西，再给钱");
               synchronized (businessman) {
                   System.out.println("顾客：我买到东西了");
               }
           }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (businessman) {
                System.out.println("商人：先给钱，再给东西");
                synchronized (customer) {
                    System.out.println("商人：我赚到钱了");
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
/**
 * 结果：（死锁住了）
 * 顾客：先给东西，再给钱
 * 商人：先给钱，再给东西
 */
