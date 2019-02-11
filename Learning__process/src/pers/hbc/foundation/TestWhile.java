package pers.hbc.foundation;

//求1!+2!+3!+....+10!
public class TestWhile {
    public static void main(String[] args) {
        int i = 1;
        int temp = 1;
        int sum = 0;
        while(i<=10) {
             temp *= i;
             sum += temp;
             i++;
        }
        System.out.println(sum);
    }
}
