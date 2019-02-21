package hbc.test1;


import java.math.BigInteger;


/**
 *
 一个N位的十进制正整数，如果它的每个位上的数字的N次方的和等于这个数本身，则称其为花朵数。
 例如：
 当N=3时，153就满足条件，因为 1^3 + 5^3 + 3^3 = 153，这样的数字也被称为水仙花数（其中，
 “^”表示乘方，5^3表示5的3次方，也就是立方）。
 当N=4时，1634满足条件，因为 1^4 + 6^4 + 3^4 + 4^4 = 1634。
 当N=5时，92727满足条件。
 实际上，对N的每个取值，可能有多个数字满足条件。

 程序的任务是：求N=21时，所有满足条件的花朵数。注意：这个整数有21位，它的各个位数字的21次
 方之和正好等于这个数本身。

 如果满足条件的数字不只有一个，请从小到大输出所有符合条件的数字，每个数字占一行。因为这个
 数字很大，请注意解法时间上的可行性。

 */


public class Test02 {
    public static void main(String[] args) {
        //定义一个数组统计0-9每个数字的21次方
        BigInteger[] num = {F(0),F(1),F(2),F(3),F(4),F(5),F(6),F(7),F(8),F(9)};
        //定义一个数组储存每个数字在21位数中出现的次数
        int[] count = new int[10];
        fun(num,count,0,0);
    }

    //求每个数的21次方
    public static BigInteger F(int n) {
        BigInteger a = BigInteger.ONE;//sum值初始化为1
        for(int i=0; i<21; i++) {
            a = a.multiply(BigInteger.valueOf(n));//n不变就是求次方，变就是求 阶乘
        }
        return a;
    }

    //m表当前处理的是count数组的第几位
    //n表示
    public static void fun(BigInteger[] num,int[] count,int m,int n) {
        if(m==9) {
            count[9] = 21-n;
            calculate(num,count);
            return ;
        }
        //对当前所有位置进行枚举
        for(int i=0; i<21-n; i++) {
            count[m] = i;
            fun(num,count,m+1,n+i);
        }
    }

    public static void calculate(BigInteger[] num, int[] count) {
        BigInteger b = BigInteger.ZERO;
        for(int i=0; i<10; i++) {
            b = b.add(num[i].multiply(BigInteger.valueOf(count[i])));
        }
        String str = ""+b;
        if(str.length()!=21) {
            return ;
        }
        int[] count2 = new int[10];
        //确认和中各数字出现多少次
        for(int i=0; i<21; i++) {
            count2[str.charAt(i)-'0']++;
        }
        //测试count和count2是否完全匹配
        for(int i=0; i<10; i++) {
            if(count[i]!=count2[i]){
                return ;
            }
        }
        //匹配打印结果
        System.out.println(str);
    }
}
/**
 128468643043731391252
 449177399146038697307
 */