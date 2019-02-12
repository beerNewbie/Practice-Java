package pers.hbc.foundation;

public class TestFor {
    public static void main(String[] args) {
        //乘法口诀表
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=i; j++) {
                System.out.printf(i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println();
        }
        System.out.println("*************************");
        //输出1-1000间的能被5整除的数，每行5个
        int count = 0;
        for(int i=1; i<=1000; i++) {
            if(i%5==0) {
                count++;
                System.out.print(i+"\t");
                /*
                if(i%25==0) {
                    System.out.println();
                }*/
                if(count==5) {
                    System.out.println();
                    count = 0;
                }
            }
        }
    }


}
