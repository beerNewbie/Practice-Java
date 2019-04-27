package per.hbc.testProducerAndConsumer.myPc;

/**
 * @Author: Beer
 * @Date: 2019/4/21 11:52
 * @Description:
 */
public class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.get();
    }
}
