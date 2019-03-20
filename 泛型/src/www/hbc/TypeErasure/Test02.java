package www.hbc.TypeErasure;

import java.lang.reflect.Field;

/**
 * @Author: Beer
 * @Date: 2019/3/20 11:29
 * @Description:类型擦除
 */
class MyClass2<T,E> {
    private T msg;
    private E text;

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }

    public E getText() {
        return text;
    }

    public void setText(E text) {
        this.text = text;
    }
}
public class Test02 {
    public static void main(String[] args) {
        MyClass2<String,Integer> myClass2 = new MyClass2<>();
        Class cls = myClass2.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType());
        }
    }
}
/**
    Field是一个类，位于java.lang.reflect包下。在java反射中Field类是描述类的
 属性信息，功能：获取当前对象的成员变量的类型；对成员变量重新设值。
    获取Field类的四种方法：
 Class.getFields()：获取类中public类型的属性，返回一个包含某些Field对象的
                    数组，该数组包含Class对象所表示的类或接口的所有可访问
                    公共字段。
 getDeclaredFields():获取类中所有的属性（public,protected,default,private)，
                    但不包括继承的属性，返回Field对象的一个数组
 getField(String name):获取类特定的方法，name参数指定了属性的名称
 getDeclaredField(String name):获取类特定的方法，name参数指定了属性的名称
 */