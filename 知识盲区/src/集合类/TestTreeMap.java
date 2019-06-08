package 集合类;

import java.util.TreeMap;

/**
 * @Author: Beer
 * @Date: 2019/6/8 22:38
 * @Description: TreeMap中有序是key还是value??是key
 */
public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        /*tm.put(3,9);
        tm.put(5,2);
        tm.put(1,6);
        System.out.println(tm);//{1=6, 3=9, 5=2}*/

        tm.put(1,9);
        tm.put(2,6);
        tm.put(3,8);
        tm.put(1,6);
        System.out.println(tm);//{1=6, 2=6, 3=8}
        //取出最后一个元素（即key值最大的元素）
        System.out.println(tm.lastEntry().getValue());//8
    }
}
