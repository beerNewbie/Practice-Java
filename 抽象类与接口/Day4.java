/**
 * 工厂方法模式-多个产品呈现出家族式特点时
 * 组成:
 * 1.一个抽象的产品类
 * 2.多个具体产品类
 * 3.一个抽象工厂类
 * 4.多个具体工厂类(AppleFatory MSFatory)
 * 工厂方法模式是针对每个产品家族提供一个工厂类，在客户
 * 端中判断使用哪个家族产品，使用哪个工厂类去生产对象。
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
        System.out.println("This is a SurfaceBook");
    }
}
interface ComputerFactory {
    Computer produceComputer();
}
class MsFactory implements ComputerFactory {
    public Computer produceComputer() {
        return new SurfaceBook();
    }
}
class AppleFactory implements ComputerFactory {
    public Computer produceComputer() {
        return new Macbook();
    }
}
public class Day1 {
    public void buyComputer(Computer computer) {
        computer.printComputer();
    }
    public static void main(String[] args) {
        Day1 customer = new Day1();
        ComputerFactory factory = new AppleFactory();
        customer.buyComputer(factory.produceComputer());
    }
}
