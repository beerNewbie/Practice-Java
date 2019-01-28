/**
 * 1.定义操作标准
 * 2.表示能力
 * 3.在分布式开发之中暴露远程服务方法
 */
//定义一个USB标准
interface USB {
    public void setup() ;//安装USB驱动
    public void work() ;//工作
}
//定义一个电脑类
class Computer {
    public void plugin(USB usb) {
        usb.setup();
        usb.work();
    }
}
//定义USB子类
class UDisk implements USB {
    public void setup() {
        System.out.println("安装U盘驱动");
    }
    public void work() {
        System.out.println("U盘工作");
    }
}
class PrintDisk implements USB {
    public void setup() {
        System.out.println("安装打印机驱动");
    }
    public void work() {
        System.out.println("打印机工作");
    }
}
public class Day1 {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.plugin(new UDisk());
        computer.plugin(new PrintDisk());
    }
}
