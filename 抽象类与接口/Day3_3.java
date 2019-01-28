/**
 * 简单工厂模式-
 * 第三方:一个具体工厂类
 * 解决:将客户端中的new操作解耦到工厂类中。每当有新商品产生，无须修改客户端代码
 * 组成:
 * 1.一个抽象的产品接口(类)
 * 2.多个具体产品类
 * 3.一个工厂(生产所有商品)
 *
 * 优点:
 * 1.简单易于实现
 * 2.将类的实例化操作解耦到工厂中，无须修改客户端
 *
 * 缺点:
 * 每当有新商品产生时，都得修改工厂类代码让其支持新商品，违反OCP原则(需要后续结合反射机制解决)
 */
interface Computer {
    void printComputer();
}
class Macbook implements Computer {
    public void printComputer() {
        System.out.println("This is a Mac");
    }
}
class SurfaceBook implements Computer {
    public void printComputer() {
        System.out.println("This a Surface");
    }
}
class ComputerFactory {
    public static Computer getInstance(String type) {
        Computer computer = null;
        if (type.equals("Macbook")) {
            computer = new Macbook();
        }else if(type.equals("SurfaceBook")) {
            computer = new SurfaceBook();
        }
        return computer;
    }
}
public class Day1 {
    public void buyComputer(Computer computer) {
        computer.printComputer();
    }
    public static void main(String[] args) {
        Day1 customer = new Day1();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要电脑的型号：");
        String type = scanner.nextLine();
        Computer computer = ComputerFactory.getInstance(type);
        customer.buyComputer(computer);
    }
}
