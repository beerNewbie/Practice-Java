package per.hbc.testProducerAndConsumer.myPc;

/**
 * @Author: Beer
 * @Date: 2019/4/21 11:53
 * @Description:
 */
public class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        super();
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.set("漏油的奔驰车");
    }
}
