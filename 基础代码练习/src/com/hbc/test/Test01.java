package com.hbc.test;

//1.创建一个Test类，包含有一个public权限的int型成员变量与一个char类
//型的成员变量，观察在main方法中的初始值。
class Test {
    public int a;
    public char b;
}

public class Test01 {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.a);
        System.out.println(test.b);
    }
}
