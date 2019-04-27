package per.hbc.testProducerAndConsumer.myPc;

/**
 * @Author: Beer
 * @Date: 2019/4/21 11:52
 * @Description:
 */
public class Goods {
    private String name;
    private int count;//批量修改shift+F6

    //生产方法
    public synchronized void set(String name) {
        this.name = name;
        this.count = count + 1;
        System.out.println(toString());
    }

    //消费方法
    public synchronized void get() {
        //每次消费一个商品
        this.count = this.count - 1;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
