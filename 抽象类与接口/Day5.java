/**
 * 抽象工厂模式进一步扩展了工厂方法模式，它把原先的工厂方法模式
 * 中只能有一个抽象产品不能添加产品族的缺点克服了，抽象工厂模式
 *不仅仅遵循了OCP原则，而且可以添加更多产品(抽象产品),具体工厂也
 * 不仅仅可以生成单一产品，而是生成一组产品，抽象工厂也是声明一
 * 组产品，对应扩展更加灵活，但是要是扩展族系就会很笨重。
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
        System.out.println("This is a Surface");
    }
}
interface OpreatingSystem {
    void printSystem();
}
class MacOsSystem implements OpreatingSystem {
    public void printSystem() {
        System.out.println("This is a Mac OS");
    }
}
class WindowsSystem implements OpreatingSystem {
    public void printSystem() {
        System.out.println("This is a Windows");
    }
}
interface ProduceFactory {
    Computer produceComputer();
    OpreatingSystem produceSystem();
}
class AppleFactory implements ProduceFactory {
    public Computer produceComputer() {
        return new Macbook();
    }
    public OpreatingSystem produceSystem() {
        return new MacOsSystem();
    }
}
class MsFactory implements ProduceFactory {
    public Computer produceComputer() {
        return new SurfaceBook();
    }
    public OpreatingSystem produceSystem() {
        return new WindowsSystem();
    }
}
public class Day1 {
    public static void buyComputer(Computer computer) {
        computer.printComputer();
    }
    public static void use(OpreatingSystem s) {
        s.printSystem();
    }
    public static void main(String[] args) {
        Day1 customer = new Day1();
        ProduceFactory factory = new MsFactory();
        Computer computer = factory.produceComputer();
        OpreatingSystem system = factory.produceSystem();
        Day1.buyComputer(computer);
        Day1.use(system);
    }
}
