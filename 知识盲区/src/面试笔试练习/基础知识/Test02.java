package 面试笔试练习.基础知识;


import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/8/19 15:29
 * @Description: 数组的深浅拷贝排序
 */
interface IntCompare {
    int cmp(int a, int b);
}

class Cmp1 implements IntCompare {
    @Override
    public int cmp(int a, int b) {
        return a - b;
    }
}

class Cmp2 implements IntCompare {
    @Override
    public int cmp(int a, int b) {
        return b - a;
    }
}

public class Test02 {
    //对传进来的数组进行排序
    public static void sortArr(int[] arr, IntCompare cmp) {
        if (arr == null) return;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j >= 1 && cmp.cmp(arr[j - 1], temp) > 0) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {3, 7, 1, 8, 4, 2, 9, 0};
        //拷贝后两数组不是引用同一个地址
        int[] arr2 = arr1.clone();
        System.out.println(arr1);
        System.out.println(arr2);
        sortArr(arr1, new Cmp1());
        System.out.println(Arrays.toString(arr1));
        sortArr(arr2, new Cmp2());
        System.out.println(Arrays.toString(arr2));
    }
    /**
     * 结果：
     * [I@1540e19d
     * [I@677327b6
     * [0, 1, 2, 3, 4, 7, 8, 9]
     * [9, 8, 7, 4, 3, 2, 1, 0]
     */

}
