package pers.hbc.testSet;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Beer
 * @Date: 2019/4/10 10:54
 * @Description: HashSet无序存储
 */
public class TestHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("world");
        set.add("haha");
        set.add("hehe");
        System.out.println(set);
        System.out.println(set.remove("hehe"));
        System.out.println(set.contains("hehe"));
        System.out.println(set);
    }

}
/**
 * 结果：
 * [haha, world, Hello, hehe]
 * true
 * false
 * [haha, world, Hello]
 */
