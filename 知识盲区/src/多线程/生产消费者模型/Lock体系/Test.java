package 多线程.生产消费者模型.Lock体系;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Beer
 * @Date: 2019/7/20 22:35
 * @Description: 使用newCondition
 */
class Goods {
    private String goodName;
    private int count;
    private int maxCount;
    private Lock lock = new ReentrantLock();
    //生产者等待对列
    private Condition producerCondition = lock.newCondition();
    //消费者不等待对列
    private Condition consumerCondition = lock.newCondition();

    //构造方法
    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * 生产商品
     * @param name
     */
    public void setGoods(String name) {
        try {
            lock.lock();
            while (count == maxCount) {
                //当商品达到最大值时,生产者等待
                System.out.println(Thread.currentThread().getName()
                        +"商品答达到最大值停止生产！！");
                producerCondition.await();
            }
            this.goodName = name;
            count ++;
            System.out.println(Thread.currentThread().getName()
                    + "生产" + toString());
            //唤醒消费者线程
            consumerCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void getGoods() {
        try {
            lock.lock();
            while (count == 0) {
                System.out.println(Thread.currentThread().getName()
                        +"商品已售完，消费者等待。。。");
                consumerCondition.await();
            }
            this.count--;
            System.out.println(Thread.currentThread().getName()
                    +"消费"+toString());
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
        return "Goods{goodsName:" + goodName + ",count:"
                + count + "}";
    }
}

class Producter implements Runnable {
    private Goods goods;

    public Producter(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.goods.setGoods("电脑");
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
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.goods.getGoods();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods(10);
        Producter producter = new Producter(goods);
        Consumer consumer = new Consumer(goods);
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(producter,"生产者"+(i+1));
            list.add(thread);
        }
        for (int i = 0; i < 10; i++) {
            Thread thread  =new Thread(consumer,"消费者"+(i+1));
            list.add(thread);
        }
        for (Thread thread : list) {
            thread.start();
        }
    }
}
