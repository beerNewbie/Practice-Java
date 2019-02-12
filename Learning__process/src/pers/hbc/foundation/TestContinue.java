package pers.hbc.foundation;

//将100-150之间不能被3整除的数输出，每行5个
public class TestContinue {
    public static void main(String[] args) {
        int count = 0;
        for(int i=100; i<=150; i++) {
            if(i%3==0) {
                continue;//是3的倍数，则跳过本次循环，继续下次循环
            }
            System.out.print(i+"\t");
            count++;
            if(count==5) {
                System.out.println();
                count = 0;
            }
        }
    }
}
