package pers.hbc.TestMap;

import java.util.Hashtable;
import java.util.Map;

/**
 * @Author: Beer
 * @Date: 2019/4/14 20:57
 * @Description:
 */
public class TestHashtable {
    public static void main(String[] args) {
        Map<Integer, String> map = new Hashtable<>();
        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Python");
        map.put(4, "PHP");
        map.put(2, "C");//覆盖
        //map.put(5, null);//NullPointerException
        System.out.println(map);//{4=PHP, 3=Python, 2=C, 1=Java}
    }
}
