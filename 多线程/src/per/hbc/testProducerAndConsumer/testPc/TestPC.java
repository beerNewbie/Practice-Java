package per.hbc.testProducerAndConsumer.testPc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Beer
 * @Date: 2019/4/27 23:30
 * @Description: 生产消费者模型（单个线程）
 */
class Goods {
    //商品名称
    private String name;
    //商品数量
    private int count;

    //生产商品方法
    public synchronized void setGoods(String name) {
        //此时有商品剩余，等待消费者消费
        while (count > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.count++;
        System.out.println(Thread.currentThread().getName() + "生产" + toString());
        //生产商品后唤醒消费者
        notifyAll();
    }

    //消费商品方法
    public synchronized void getGoods() {
        //无剩余商品，等待消费者消费
        while (count == 0) {
            try {
                System.out.println("商品已卖完,请等待...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println(Thread.currentThread().getName() + "消费" + toString());
        //消费完商品后告诉生产者继续生产
        notifyAll();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}

//生产者
class Productor implements Runnable {
    private Goods goods;

    public Productor(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            this.goods.setGoods("一台电脑");
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
            this.goods.getGoods();
        }
    }
}

public class TestPC {
    public static void main(String[] args) {
        Goods goods = new Goods();
        List<Thread> list = new ArrayList<>();
        Productor productor = new Productor(goods);
        Consumer consumer = new Consumer(goods);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(productor, "生产者"+i);
            list.add(thread);
        }
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(consumer, "消费者");
            list.add(thread1);
        }
        for (Thread thread : list) {
            thread.start();
        }
    }

}
