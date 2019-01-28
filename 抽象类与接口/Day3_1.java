/**
 *1. 接口优先（在一个操作既可以使用抽象类又可以使用接口的时候，优先考虑使用接口）
 *2.接口定义：接口就是抽象方法和全局常量的集合，在Java中接口使用interface关键字定义
 *3.访问修饰符：只能是public或默认。
 *4. 接口名：和类名采用相同命名机制。
 *5. extends：接口可以多继承
 *6. 常量：接口中的属性只能是常量，总是：public static final 修饰。不写也是。
 *7. 方法：接口中的方法只能是：public abstract。 省略的话，也是public abstract。
 */

//子类实现接口和父接口间的相互转换
interface IMessage {
    public static final String MSG = "Hellow world";
    public abstract void print() ;//抽象方法
}
interface INews {
    public abstract String getNews() ;
}
class MessageImpl implements IMessage,INews {
    public void print() {
        System.out.println(IMessage.MSG);
    }
    public String getNews() {
        return IMessage.MSG;
    }
}
public class Day1 {
    public static void main(String[] args) {
        IMessage m = new MessageImpl();//子类向上转型，为父类接口实例化对象
        m.print();
        INews n = (INews) m;
        System.out.println(n.getNews());
    }
}
