package pers.hbc.TestMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Beer
 * @Date: 2019/4/14 21:07
 * @Description:
 */
public class TestIteratorMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Python");
        //Map——>Set
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        //取得Set接口迭代器
        Iterator<Map.Entry<Integer, String>> iterator = set.iterator();
        //迭代输出
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
/**
 结果：
 1=Java
 2=C++
 3=Python
 */