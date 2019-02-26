package com.hbc.test;

//3.写出下面程序运行结果:
class A1{
    public A1(){
        System.out.println("A");
    }
}

class Test07 extends A1{
    public Test07(){
        System.out.println("B");
    }

    public static void main(String[] args){
        Test07 b=new Test07();
    }
}
//结果：A
//     B