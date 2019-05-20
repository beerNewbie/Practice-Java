package per.hbc.testLock.testConditionProduceAndConsume;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Beer
 * @Date: 2019/5/20 11:38
 * @Description: 基于Lock+Condition的生产消费者模型
 */

class Goods {
    private String name;
    private int maxCount;
    private int count;
    private Lock lock = new ReentrantLock();
    //生产者等待多列
    private Condition producerCondition = lock.newCondition();
    //消费者等待队列
    private Condition consumerCondition = lock.newCondition();

    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * 生产者方法
     *
     * @param name
     */
    public void setGoods(String name) {
        try {
            lock.lock();
            while (count == maxCount) {
                //当前商品达到最大值，生产者等待
                System.out.println(Thread.currentThread().getName() + "商品已达到最大值停止生产！！！");
                producerCondition.await();
            }
            this.name = name;
            count++;
            System.out.println(Thread.currentThread().getName() + "生产" + toString());
            //唤醒消费者线程
            consumerCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 消费者方法
     */
    public void getGoods() {
        try {
            lock.lock();
            while (count == 0) {
                System.out.println(Thread.currentThread().getName() + "商品已售罄，消费者等待");
                consumerCondition.await();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "消费" + toString());
            //唤醒生产者线程
            producerCondition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

}

class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                this.goods.setGoods("生产电脑");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                this.goods.getGoods();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods(10);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(producer,"生产者"+(i+1));
            list.add(thread);
        }
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(consumer,"消费者"+(i+1));
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.start();
        }
    }
}
