package www.hbc.WildcardDemo;

/**
 * @Author: Beer
 * @Date: 2019/3/19 12:43
 * @Description:简单使用通配符
 *  只能用在方法级别，表示指代任意类型的泛型。只能取得泛型对象中的值，
 * 无法通过setter等类似方法设置值，由于传入类型无法确定，因此无法设
 * 置具体值到相应对象中。
 */

class Message<T> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}

public class Demo01 {
    public static void main(String[] args) {
        Message<Integer> message = new Message<>();
        message.setMessage(100);
        fun(message);
    }
    //使用通配符"?"指其可以接收 任意类型，但是由于不确定类型，所以无法修改
    public static void fun(Message<?> temp) {
        //temp.setMessage(100);无法修改
        System.out.println(temp.getMessage());
    }
}
