//设计模式
   //单例设计模式
   //特点：构造方法私有化，外部无法产生新的实例化对象，只能通过static方法取得实例化对象
        //饿汉式
//    class Singleton {
//        //在类的内部可以访问私有结构，所以可以在类的内部产生实例化对象
//        private final static Singleton INSTANCE = new Singleton();
//        private Singleton() {//private声明构造
//        }
//        public static Singleton getInstance() {
//            return INSTANCE;
//        }
//        public void print() {
//            System.out.println("Hello world");
//        }
//    }
//    public class SingletonTest {
//        public static void main(String[] args) {
//            Singleton singleton = null;//声明对象
//            singleton = Singleton.getInstance();
//            singleton.print();
//        }
//    }
        //懒汉式
class Singleton {
    private static Singleton instance;
    public static Singleton getInstance() {
        if (instance == null) {
             instance = new Singleton();
        }
        return instance;
    } 
    public void print() {
        System.out.println("Hello world");
    }
}
public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton = null;
        singleton = Singleton.getInstance();
        singleton.print();
    }
}
