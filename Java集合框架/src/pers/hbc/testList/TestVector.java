package pers.hbc.testList;

import java.util.List;
import java.util.Vector;

/**
 * @Author: Beer
 * @Date: 2019/4/10 8:45
 * @Description:
 */

/**
 * 请解释ArrayList与Vector区别
 * 1. 历史时间:ArrayList是从JDK1.2提供的，而Vector是从JDK1.0就提供了。
 * 2. 处理形式：ArrayList是异步处理，性能更高；Vector是同步处理，性能较低。
 * 3. 数据安全：ArrayList是非线程安全；Vector是线程安全。
 * 4. 输出形式：ArrayList支持Iterator、ListIterator、foreach；Vector支持Iterator、ListIterator、foreach、
 * Enumeration。
 */
public class TestVector {
    public static void main(String[] args) {
        List<String> list = new Vector<>();
        list.add("Hello");
        list.add("world");
        list.add("haha");
        System.out.println(list);
        System.out.println(list.contains("haha"));
        System.out.println(list.remove("haha"));
        System.out.println(list);
    }
}
/**
 * 结果：
 * [Hello, world, haha]
 * true
 * true
 * [Hello, world]
 */
