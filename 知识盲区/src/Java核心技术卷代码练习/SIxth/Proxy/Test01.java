package Java核心技术卷代码练习.SIxth.Proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Beer
 * @Date: 2019/8/7 0:39
 * @Description: 使用代理对象对二分查找进行跟踪
 */

public class Test01 {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHander(value);
            Object proxy =
                    Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        //创建一个随机数
        Integer key = new Random().nextInt(elements.length) + 1;//区间为[1,elements.length]

        //二分搜索key
        //int result1 = Arrays.binarySearch(elements,key);
        int result = binarySearch(elements, key);


        if (result >= 0) {
            System.out.println(elements[result] + "****");
        }

    }

    /**
     * 实现自己的二分查找
     *
     * @param elements 要查找的数组
     * @param key      要查获找的元素
     * @return 元素所在的下标，若不存在返回-1；
     */
    public static int binarySearch(Object[] elements, Object key) {
        int low = 0;
        int high = elements.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable midVal = (Comparable) elements[mid];
            int cmp = midVal.compareTo(key);
            if (cmp > 0) {
                high = mid - 1;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

class TraceHander implements InvocationHandler {

    private Object target;

    public TraceHander(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(",");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}
/**
 * 结果：
 500.compareTo(656)
 750.compareTo(656)
 625.compareTo(656)
 687.compareTo(656)
 656.compareTo(656)
 656.toString()
 656****
 */