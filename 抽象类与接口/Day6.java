/**
 * 代理设计模式：
 *    两个子类共同实现一个接口，其中一个子类负责真实业务实现，
 *   另外一个子类完成辅助真实业务主题的操作。
 */
interface ISubject {
    void buyComputer();
}
class RealSubject implements ISubject {
    public void buyComputer() {
        System.out.println("买一台苹果电脑");
    }
}
class ProxySubjekt implements ISubject {
    private ISubject subject;
    public ProxySubjekt(ISubject subject) {
        this.subject = subject;
    }
    public void produceComputer() {
        System.out.println("生产一台苹果电脑");
    }
    public void afterSale() {
        System.out.println("售后服务");
    }

    public void buyComputer() {
        this.produceComputer();
        this.subject.buyComputer();
        this.afterSale();
    }
}
class Factory {
    public static ISubject getInstance() {
        return new ProxySubjekt(new RealSubject());
    }
}
public class Day1 {
    public static void main(String[] args) {
        ISubject subject = Factory.getInstance();
        subject.buyComputer();
    }
}
