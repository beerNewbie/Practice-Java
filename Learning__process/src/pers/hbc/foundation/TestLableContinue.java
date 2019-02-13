package pers.hbc.foundation;

//打印101-200之间的质数
public class TestLableContinue {
    public static void main(String[] args) {
        int count = 0;
        outer:for(int i=101; i<200; i+=2) {//偶数不可能是质数
        for(int j=2; j<=Math.sqrt(i); j++){//乘数肯定小于等于它的平方根
            if(i%j==0) {
                continue outer;
            }
        }
        count++;
            System.out.print(i+" ");
        }
        System.out.println("\n"+"count="+count);
        System.out.println("***************************");
        //普通方法
        boolean flag;
        int count2 = 0;
        for(int i=101; i<=200; i+=2) {
            flag = true;
            for(int j=2; j<=Math.sqrt(i); j++) {
                if(i%j==0){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count2++;
                System.out.print(i+" ");
            }
        }
        System.out.println("\n"+"count2="+count2);
    }

}
