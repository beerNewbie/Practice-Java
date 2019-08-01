package Java核心技术卷代码练习.SIxth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * @Author: Beer
 * @Date: 2019/8/1 23:23
 * @Description: ArrrayList类中的removeIf()中有一个参数Predicate，这个接口专门用来传递Lambda表达式
 */
public class LambdaTest02 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = new int[] {1,5,3,6,2,7,2,9,2,8,2};
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(list);//[1, 5, 3, 6, 2, 7, 2, 9, 2, 8, 2]
        list.removeIf(e -> e.equals(2)) ;
        System.out.println(list);//[1, 5, 3, 6, 7, 9, 8]
    }
}
