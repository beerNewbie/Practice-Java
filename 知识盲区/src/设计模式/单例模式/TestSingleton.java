package 设计模式.单例模式;


/**
 * @Author: Beer
 * @Date: 2019/9/9 23:39
 * @Description: 饿汉式单例
 *
 * 现在Singleton内部的instance对象（属性）是一个普通属性，所有的普通属性必须在有实例化对象的时候才能进行
 * 内存空间的分配，而现在外部无法产生实例化对象，所以必须想一个办法，可以在Singleton没有实例化对象产生
 * 的时候，也可以将instance进行使用。此时，联想到使用static关键字。
 */
 class HangerSingleton {
     private static final HangerSingleton INSTANCE = new HangerSingleton();
     private HangerSingleton() {}
     public void print(String str) {
         System.out.println(str);
     }
     public static HangerSingleton getInstance() {
         return INSTANCE;
     }
}

public class TestSingleton {
    public static void main(String[] args) {
        HangerSingleton.getInstance().print("Hello Singleton");
    }
}
