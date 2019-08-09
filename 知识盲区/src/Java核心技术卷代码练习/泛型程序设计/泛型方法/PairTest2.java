package Java核心技术卷代码练习.泛型程序设计.泛型方法;


import java.time.LocalDate;

/**
 * @Author: Beer
 * @Date: 2019/8/10 0:39
 * @Description: 计算泛型数组的最大值最小值
 */

class Pair<T> {
    private T first;
    private T second;

    public Pair() {
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}

class ArrayAlg {
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min,max);
    }
}

public class PairTest2 {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(2009,2,18),
                LocalDate.of(1998,3,29),
                LocalDate.of(1999,1,30),
                LocalDate.of(2000,10,18),
                LocalDate.of(2019,8,10)
        };
        Pair<LocalDate> pair = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + pair.getFirst());
        System.out.println("max = " + pair.getSecond());
    }
    /**
     * 结果：
     * min = 1998-03-29
     * max = 2019-08-10
     */
}
