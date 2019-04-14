package pers.hbc.testCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Beer
 * @Date: 2019/4/14 21:26
 * @Description:
 */
public class TestCollections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //向集合中一次添加多个元素
        Collections.addAll(list, "A", "a", "k", "K", "B", "b");
        //集合排序
        Collections.sort(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n");
        iterator = list.iterator();
        //集合反转
        Collections.reverse(list);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
/**
 * 结果：
 * A B K a b k
 *
 * k b a K B A
 */

