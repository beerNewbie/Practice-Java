package Java核心技术卷代码练习.泛型程序设计.泛型方法;


import java.util.ArrayList;

/**
 * @Author: Beer
 * @Date: 2019/8/11 22:37
 * @Description: 泛型的约束与局限性
 */

public class Test {
    public static void main(String[] args) {
        //Pair<String>[] table = new Pair<String>[0];//编译Error，
        Pair<String>[] table1 = new Pair[10];//OK
        /**
         * Java为什么不能创建泛型数组：
         *      因为泛型的作用是使程序在编译期间可以检查出与类型相关的错误，但
         * 如果使用泛型数组，这种能力就会被破坏。
         *      在进入JVM之前，与泛型相关的信息会被擦除掉，会替换为原始类型
         */


        /**
         *      可以编译通过，但是不安全的，如果在table[0]中存储Pair<Employee>,
         *  然后对table[0].getFirst()调用一个String方法，会得到ClassCastException
         */
        //Pair<String>[] table = (Pair<String>[]) new Pair<?>[10];

        //只有一个安全而有效的方法
        ArrayList<Pair<String>> table = new ArrayList<>();
        table.add(new Pair<String>("1","2"));
        table.add(new Pair<String>("2","3"));
        table.add(new Pair<String>("8","9"));
        System.out.println(table);


    }
}
