package com.hbc.test;

//创建一个带默认构造方法（即无参构造）的类，在构造方法中打印一条
//消息"Hello Constructor";再为这个类添加一个重载构造方法，令其接收
//一个字符串参数，并在这个有参构造方法中把"Hello Constructor"和接
//收的参数一起打印出来。

class Test2 {
    public Test2() {
        System.out.println("Hello Constructor");
    }
    public Test2(String n) {
        System.out.println("Hello Constructor"+n);

    }
}
public class Test04 {
    public static void main(String[] args) {
        Test2 test = new Test2();
        Test2 tets1 = new Test2("！！！");
    }
}
