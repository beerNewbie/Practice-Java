package pers.hbc.arrays;

public class Test02 {
    public static void main(String[] args) {
        //静态初始化
        int[] a = {1,2,3};
        User[] b = {
                     new User(1,"li1"),
                     new User(2,"li2"),
                     new User(3,"li3")
                    };
        //默认初始化
        int[] c = new int[3];//默认给数组元素进行赋值
        //动态初始化
        int[] d = new int[2];//动态初始化 数组，先分配空间
        d[0] = 1;
        d[1] = 2;
        System.out.println("*****************");
        int[] a1 = new int[10];
        for(int i=0;i<a1.length;i++){
            a1[i] = 10*i;
        }
        //foreach循环用于读取数组元素的值，不能修改元素的值
        for(int m:a1){
            System.out.print(m+"、");
        }
    }
}
