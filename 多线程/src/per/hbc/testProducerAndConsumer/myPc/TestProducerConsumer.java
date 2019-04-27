package per.hbc.testProducerAndConsumer.myPc;

/**
 * @Author: Beer
 * @Date: 2019/4/21 11:54
 * @Description:
 */
public class TestProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods();
        Thread producerThread = new Thread(new Producer(goods));
        Thread consumerThread = new Thread(new Consumer(goods));
        producerThread.start();
        Thread.sleep(1000);
        consumerThread.start();
    }
}
