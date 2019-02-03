//装箱：将基本数据类型变为包装类对象，利用每一个包装类提供的构造方法实现装箱处理
//拆箱：将包装类中 包装的基本数据类型取出。利用Number类中提供的六种方法
public class Test {
    public static void main(String[] args) {
        // Integer num = new Integer(88);//装箱 
        // int data = num.intValue();//拆箱
        // System.out.println(++data * 10); 
        Integer num1 = new Integer(10);
        Integer num2 = new Integer(10);
        System.out.println(num1 == num2);//false
        System.out.println(num1 == new Integer(10));//false
        System.out.println(num1.equals(num2));//true
        System.out.println(num1.equals(new Integer(10)));//true
        /**
         *关于基本数据类型与包装数据类型的使用标准如下：
         *1.(强制）所有的 POJO 类属性必须使用包装数据类型。
         *2.(强制)RPC 方法的返回值和参数必须使用包装数据类型。
         *3.(推荐)所有的局部变量使用基本数据类型。
         */
    }
}
