package Java核心技术卷代码练习.泛型程序设计.定义泛型类;


/**
 * @Author: Beer
 * @Date: 2019/8/9 23:10
 * @Description:
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
    /**
     *  得到字符串数组的最大最小值
     * @param a 字符串数组
     * @return 返回一个Pair的对象
     */
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        String max = a[0];
        String min = a[0];
        for (int i = 0; i < a.length; i++) {
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

public class PairTest1 {
    public static void main(String[] args) {
        String[] strings = new String[] {"sun","moon","earth","people"};
        Pair<String> pair = ArrayAlg.minmax(strings);
        System.out.println("minWords = " + pair.getFirst());
        System.out.println("maxWords = " + pair.getSecond());
    }
    /**
     * 结果：
     * minWords = earth
     * maxWords = sun
     */

}
