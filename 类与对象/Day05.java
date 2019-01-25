class Person {
    public void print() {
        System.out.println("1.Father");
    }
}
class Students extends Person {
    public void print() {
        System.out.println("2.Child");
    }
    public void fun() {
        System.out.println("3.Only child");
    }
}
public class Day1 {
    public static void main(String[] args) {
        Person per = new Students();//向上转型
        per.print();
        //这个时候父类能够调用的方法只能是本类定义好的方法
        //所以并没有Student类中的fun()方法，那么只能够进行向下转型处理
        Students stu = (Students) per;
        stu.fun();
    }
}
