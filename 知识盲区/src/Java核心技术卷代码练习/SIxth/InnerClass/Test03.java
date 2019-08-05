package Java核心技术卷代码练习.SIxth.InnerClass;


import java.util.Arrays;
import java.util.Date;

/**
 * @Author: Beer
 * @Date: 2019/8/6 0:36
 * @Description: 统计一下在排序过程中调用compareTo方法的次数
 */

public class Test03 {
    public static void main(String[] args) {
        int[] count = new int[1];
        Date[] dates = new Date[10];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = new Date() {
                @Override
                public int compareTo(Date other) {
                    //count++;//编译错误
                    count[0]++;
                    return super.compareTo(other);
                }
            };

        }
        Arrays.sort(dates);
        System.out.println("count = " + count[0]);//count = 9

    }
}
