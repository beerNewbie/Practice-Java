package pers.hbc.foundation;

//递归和循环求阶乘
public class TestRecursion {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.printf("%d阶乘的结果：%s%n",10,factorial(10));
        long t2 = System.currentTimeMillis();
        System.out.printf("递归费时为：%s%n",t2-t1);
        //循环
        System.out.printf("%d的阶乘结果为：%s%n",10,factorialLoop(10));
        long t3 = System.currentTimeMillis();
        System.out.printf("递归费时为：%s%n",t3-t2);

    }
    static long factorial(int n) {
        if(n==1) {
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }

    static long factorialLoop(int n) {
        long result = 1;
        while(n>1) {
            result *= n*(n-1);
            n-=2;
        }
        return result;
    }
}
