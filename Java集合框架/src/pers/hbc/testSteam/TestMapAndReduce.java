package pers.hbc.testSteam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Beer
 * @Date: 2019/4/14 21:31
 * @Description:
 */
class Goods {
    private String name;
    private Integer count;
    private Double price;

    public Goods(String name, Integer count, Double price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
public class TestMapAndReduce {
    public static void main(String[] args) {
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("HUAWEI",500,6000.00));
        list.add(new Goods("APPLE",200,7000.00));
        list.add(new Goods("XIAOMI",600,3000.00));
        list.add(new Goods("OPPO",300,3500.00));
        Double costs = list.stream()
                .map(obj -> obj.getCount()*obj.getPrice())
                .reduce((sum,x) -> sum+x).get();
        System.out.println(costs);
    }
}
//结果：7250000.0
