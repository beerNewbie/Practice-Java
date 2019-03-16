package www.hbc.demo;

/**
 * @Author: Beer
 * @Date: 2019/3/15 22:36
 * @Description:泛型类的基本使用
 */
class Point<T> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}

public class Demo01 {
    public static void main(String[] args) {
        Point<String> p1 = new Point<>();
        p1.setX("B:30度59分23秒");
        p1.setY("L:120度10分30秒");
        String x = p1.getX();//避免了向下转型
        String y = p1.getY();
        System.out.println(x);
        System.out.println(y);
    }
}
