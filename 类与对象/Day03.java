class Outer {
    private String msg = "Hellow world!";
    class Inner {//内部类
        public void print() {//普通方法
            System.out.println(msg);
        }
    }
    //产生内部类对象并调用print方法
    public void fun() {
        Inner in = new Inner();//内部类对象
        in.print();
    }
}
public class Day2 {
    public static void main(String[] args) {
        Outer out = new Outer();//外部类对象
        out.fun();//外部类方法
    }
}
//把内部类拆开到外部
//class Outer {
//    private String msg = "Hellow world!!";
//    public String getMsg() {//取得msg属性
//        return this.msg;
//    }
//    public void fun() {//3.out对象调用fun()方法
//        Inner in = new Inner(this);//4.this表当前对象
//        in.print();//7.调用此方法
//    }
//}
//class Inner {
//    private Outer out;
//    public Inner(Outer out) {//5.Inner.out=main.out
//        this.out = out;//6.引用传递
//    }
//    public void print() {//8.执行此方法
//        System.out.println(out.getMsg());
//    }
//}
//
//public class Day2 {
//    public static void main(String[] args) {
//        Outer out = new Outer();//1.实列化Outer类对象
//        out.fun();//2.调用Outer类方法
//    }
//}
