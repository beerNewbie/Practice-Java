package com.hbc.test;

/**
 * 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是
 * 指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
 */
public class Test08 {
    public static void main(String[] args) {
        for(int i=100; i<=999; i++) {
            int temp = i;
            int sum = 0;
            while(temp>0) {
                sum += Math.pow(temp%10,3);
                temp/=10;
            }
            if (sum==i) {
                System.out.println(i);
            }
        }
    }
}
