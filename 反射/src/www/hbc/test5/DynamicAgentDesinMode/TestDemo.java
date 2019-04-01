package www.hbc.test5.DynamicAgentDesinMode;

/**
 * @Author: Beer
 * @Date: 2019/4/2 0:45
 * @Description:
 */
public class TestDemo {
    public static void main(String[] args) {
        ISubject subject = (ISubject) new ProxySubject().bind(new RealSubject());
        subject.eat("hamburger",10);
    }
}
/**
 * 结果：
 * [ProxySubjext] prevHandle
 * I want to eat 10 sizes' hamburger
 * [ProxySubject] afterHandle
 */

