package pers.hbc.TestMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Beer
 * @Date: 2019/4/14 20:46
 * @Description:
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Python");
        map.put(4, "PHP");
        map.put(null, "C");
        map.put(null, null);
        map.put(5, null);
        //获取key
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\n" + map.get(null));
    }
}
/**
 结果：
 null 1 2 3 4 5
 null
 */