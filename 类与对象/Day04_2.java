/**
 * 方法覆写和方法重载：
 *    概念 ：方法覆写是方法名称，返回类型、参数类型、个数完全相同
 *           方法重载是方法名称相同，参数的类型及个数不同
 *    范围：方法覆写：继承关系（子类父类）
 *          方法重载：一个类
 *    限制：方法覆写：被覆写的方法不能有比父类更严格的控制访问权限
 *          方法重载：没有限制要求
 */
class Person {
    public void print() {
        System.out.println("1.Person类的print方法");
    }
}
class Students extends Person {
    public void print() {
        System.out.println("2.Students类的print方法");
    }
}
public class Day04 {
    public static void main(String[] args) {
        new Students().print();
    }
}
