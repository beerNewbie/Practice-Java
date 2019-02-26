package com.hbc.test;

//2.编写一个程序，展示无论你创建了某个特定类的多少个对象，这个类的
//某个特定的static成员变量只有一个属性。

class Test1 {
    public int a;
    public char b;
    public static int c = 10;

    public Test1(int a, char b) {
        this.a = a;
        this.b = b;
    }
}
public class Test02 {
    public static void main(String[] args) {
        Test1 test1 = new Test1(8,'9');
        Test1 test2 = new Test1(12, '7');
        System.out.println(test1.a+" "+test1.b+" "+test1.c);
        System.out.println(test2.a+" "+test2.b+" "+test1.c);
    }
}
