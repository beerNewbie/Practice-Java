/**
 * throws关键字：
 *  用在方法声明上，明确告诉调用者本方法可能产生的异常，但方法本身不处理，将异常抛回给调用方。
 */
//使用throws定义方法
//public class Test {
//    public static void main(String[] args) {
//        try {
//            System.out.println(calculate(10,0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static int calculate(int x, int y) throws Exception {
//        return x/y;
//    }
//}
/**
 * 主方法抛出异常:
 *    主方法上也可以使用throws进行异常抛出，这个时候如果产生了异常就会交给JVM处理。
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(calculate(10,0));
    }
    public static int calculate(int x, int y) throws Exception {
        return x/y;
    }
}
