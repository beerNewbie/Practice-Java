package pers.hbc.testSteam;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: Beer
 * @Date: 2019/4/14 21:34
 * @Description:
 */
public class TestDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6);
        //list.forEach(System.out::print);//123456
        Stream<Integer> stream = list.stream();
        //偶数个数
   /*     System.out.println("count = " +
                stream.filter(e -> e % 2 == 0).count());//3*/
        //求集合中的最大最小值
        System.out.println(stream.max(Integer::compareTo)
                .get());//6
    }
}
