package pers.hbc.testIteraror;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Beer
 * @Date: 2019/4/14 20:25
 * @Description:
 */
public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","B","C","D","E");
        //modCount = 6
        Iterator<String> iterator = list.iterator();
        //取得集合迭代器（取得当前集合的副本）
        //expectedModCount = 6
        while(iterator.hasNext()) {
            //调用checkForComodification检查副本中的exceptedModCount是否等于集合的modCount
            String str = iterator.next();
            if (str.equals("B")) {
                //list.remove("B");//集合类提供的remove方法，报错：ConcurrentModeficationException;
                iterator.remove();//正确
                continue;
            }
            System.out.print(str + " ");//A C D E
        }
    }
}
