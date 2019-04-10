package pers.hbc.testList;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Beer
 * @Date: 2019/4/10 9:44
 * @Description:
 */
public class TestLinkedListt {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        System.out.println(list.remove(3));
        System.out.println(list.contains(4));
        System.out.println(list);
    }
}
/**
 * 结果：
 * [1, 2, 3, 4, 5]
 * 4
 * false
 * [1, 2, 3, 5]
 */
