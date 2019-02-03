//包装类：将基本数据类型封装到类中 
    //自己定义一个包装类 
class IntDemo {
    private int num;
    public IntDemo(int num) {
        this.num = num;
    }
    public int intValue() {
        return this.num;
    }
}
public class Test {
    public static void main(String[] args) {
        Object obj = new IntDemo(88);//子类向上转型
        IntDemo temp = (IntDemo) obj;//向下转型
        System.out.println(temp.intValue());//取出里面的基本数据类型操作
        //结论：将基本数据类型包装为一个类对象的本质就是使用Object进行接收处理
    }
}
