//RuntimeException类
    //使用RuntimeException定义的异常类可以不需要强制性进行异常处理。
public class Test {
    public static void main(String[] args) {
        String str = "100";
        int num = Integer.parseInt(str);
        System.out.println(num/2);
    }
}
/**
 * 解释Exception与RuntimeException的区别，请列举几个常见的RuntimeException：
 *   1. 使用Exception是RuntimeException的父类，使用Exception定义的异常都要求必须使用异常处理，而
 * 使用RuntimeException定义的异常可以由用户选择性的来进行异常处理。
 *   2. 常见的RuntimeException:ClassCastException、NullPointerException等。
 */
