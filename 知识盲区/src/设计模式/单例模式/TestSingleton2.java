package 设计模式.单例模式;


/**
 * @Author: Beer
 * @Date: 2019/9/9 23:55
 * @Description: 懒汉式单例
 */

class LazySingleton {
    private static volatile LazySingleton lazySingleton ;
    private LazySingleton() {
    }

    public void print(String str) {
        System.out.println(str);
    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }


}

public class TestSingleton2 {
    public static void main(String[] args) {
        LazySingleton.getInstance().print("Hello LazySingleton");
    }
}
