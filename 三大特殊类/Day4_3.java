//字符串与基本数据类型转换
    /**
     * 1. String变为int 类型（Integer类）：public static int parseInt(String s) throws
     *    NumberFormatException
     * 2.String变为double类型（Double类）：public static double parseDouble(String s) throws
     *   NumberFormatException
     * 3.String变为Boolean类型（Boolean类）：public static boolean parseBoolean(String s)
     */
public class Test {
    public static void main(String[] args) {
        String str = "123";
        int num1 = Integer.parseInt(str);//字符串变为int型
        System.out.println(num1);
        double num = Double.parseDouble(str);//字符串变为double型
        System.out.println(num);
        /**
         * 将字符串转为数字的时候，字符串的组成有非数字，
         * 那么转换就会出现错误（NumberFormatException）
         */
        String str1 = "hello";
        boolean num2 = Boolean.parseBoolean(str1);//字符串与boolean转换不受影响
        System.out.println(num2);
        String str2 = String.valueOf(88);//的valueOf()方法，此方法不产生垃圾。
        System.out.println(str2);
    }
}
