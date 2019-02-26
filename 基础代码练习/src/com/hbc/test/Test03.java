package com.hbc.test;

//3.一个斐波那契数列是由数字1、1、2、3、5、8、13、21、34等等组成
//的，其中每一个数字(从第三个数字起)都是前两个数字的和。创建一个方
//法，接受一个整数参数，并显示从第一个元素开始总共由该参数指定的
//个数所构成的所有斐波那契数字。
//例如，如果运行 java Fibonacci 5(Fibonacci为类名)，那么输出应该
//是1、1、2、3、5。

class Fibonacci {
    public int fibonacci(int n) {
//        if(n<=2) {
//            return 1;
//        }else {
//            return fibonacci(n-2)+fibonacci(n-1);
//        }
        int a = 1;
        int b = 1;
        int c = 1;
        if (n>2) {
            for (int i=3; i<=n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }

    public void print(int n) {
        for(int i=1; i<=n; i++) {
            System.out.print(fibonacci(i)+"、");
        }
    }
}

public class Test03 {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        fib.print(5);
    }

}
