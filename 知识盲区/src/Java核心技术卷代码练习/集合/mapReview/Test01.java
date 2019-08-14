package Java核心技术卷代码练习.集合.mapReview;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Beer
 * @Date: 2019/8/13 17:00
 * @Description:
 */

public class Test01 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(3,"c");
        map.put(null,null);
        map.put(3,null);
        System.out.println(map.get(3));//null
        System.out.println(map.get(null));//null
        System.out.println(map.get(300));//null

        //遍历集合
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + " = " + next.getValue());
        }



    }
    /**
     * 结果：
     * null
     * null
     * null
     * 1 = a
     * 2 = b
     * 3 = null
     */
}
