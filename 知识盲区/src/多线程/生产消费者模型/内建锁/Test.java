package 多线程.生产消费者模型.内建锁;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Beer
 * @Date: 2019/7/20 13:26
 * @Description: 内建锁下的生产消费者模型
 */

class Goods {
    //商品名称
    private String name;
    //商品数量(初始化必须为int)
    private Integer count = 0;

    public synchronized void setGood(String name) {
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
        notifyAll();
    }

    public synchronized void getGoods() {
        while (count == 0) {
            try {
                System.out.println("商品已卖完，请等待。。。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println(Thread.currentThread().getName() + "消费" + toString());
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

class Productor implements Runnable {
    private Goods goods;

    public Productor(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.goods.setGood("电脑");
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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.goods.getGoods();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Goods goods = new Goods();
        List<Thread> list = new ArrayList<>();
        Productor productor = new Productor(goods);
        Consumer consumer = new Consumer(goods);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(productor, "生产者" + (i+1)+"号");
            list.add(thread);
        }
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(consumer, "消费者"+(i+1)+"号");
            list.add(thread1);
        }
        for (Thread thread : list) {
            thread.start();
        }
    }
}
