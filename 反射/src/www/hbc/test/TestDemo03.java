package www.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/22 23:55
 * @Description:取得父类信息
 */
interface IFruit {}
interface IMessage {}
class CLS implements IFruit,IMessage {}

public class TestDemo03 {
    public static void main(String[] args) {
        Class<?> cls = CLS.class;
        //取得package名称
        System.out.println(cls.getPackage().getName());//结果：www.hbc.test
        //取得父类名称
        System.out.println(cls.getSuperclass().getName());//java.lang.Object
        //取得实现父接口的对象
        Class<?>[] iclass = cls.getInterfaces();
        for (Class<?> class1 : iclass) {
            System.out.println(class1.getName());//www.hbc.test.IFruit  www.hbc.test.IMessage
        }
    }
}
