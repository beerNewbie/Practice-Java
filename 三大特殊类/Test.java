package 三大特殊类;
/**
 * 1."=="：进行的数值比较，比较的是两个字符串对象的内存地址数值
 * 2."equals()":可以进行字符串内容的比较
 * 3.任何的字符串常量都是String的匿名对象，所以该对象永远不会为null。
 * 4.在进行指定字符串内容与字符串对象比较时，把字符串常量写在equals前面，防止（null）运行时出错
 */
//public class Test {
//    public static void main(String[] args) {
//        String str1 = "Hello World";
//        String str = new String("Hello World");
//        System.out.println(str1==str);
//        System.out.println(str1.equals(str));
//        System.out.println("Hello World".equals(str));
//    }
//}

//String类的实例化操作：采用直接赋值，采用构造方法
public class Test {
    public static void main(String[] args) {
//        String str1 = new String("Hello");
//        String str2 = "Hello";
//        String str3 = new String("Hello").intern();
//        System.out.println(str1 == str2);//false
//        System.out.println(str2 == str3);//true
//        //在String类中提供有方法入池操作public String intern() ;
        String str = "hello";
        str = str + " world";
        str += "!!!";
        System.out.println(str);
        /**
         * 1. 字符串使用就采用直接赋值。
         * 2. 字符串比较就使用equals()实现。
         * 3. 字符串别改变太多。
         */
    }
}
