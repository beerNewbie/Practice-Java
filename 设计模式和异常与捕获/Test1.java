//异常处理格式
public class Test {
    public static void main(String[] args) {
        System.out.println("1.计算开始前");
        try{
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("2.进行数学运算"+x/y);
        }catch (ArithmeticException e) {
            e.printStackTrace();//取得异常的完整信息
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            System.out.println("[finally]不管是否产生异常都执行此语句");
        }//不管此时是否产生异常，最终都要执行finally程序代码，所以finally会作为程序统一出口。
        System.out.println("3.计算结束");
    }
}
