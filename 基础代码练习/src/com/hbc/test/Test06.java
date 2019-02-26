package com.hbc.test;

//2.简述下列程序运行结果:
class A{
    int y=6;
    class Inner{
        int y=3;
        void show(){
        System.out.println(y);
        }
    }
}
class Test06{
    public static void main(String [] args){
    A.Inner inner=new A().new Inner();
    inner.show();
    }
}

//结果为：3


