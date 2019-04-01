package www.hbc.test5.BasicAgentDesignMode;

/**
 * @Author: Beer
 * @Date: 2019/4/2 0:10
 * @Description:基础代理设计
 */
public class TestDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
        ISubject subject =
                Factory.getInstance("www.hbc.test5.BasicAgentDesignMode.ProxySubject",
                        Factory.getInstance("www.hbc.test5.BasicAgentDesignMode.RealSubject"));
        subject.eat();
         */
        ISubject subject =
                Factory.getInstance("www.hbc.test5.BasicAgentDesignMode.ProxySubject",
                        "www.hbc.test5.BasicAgentDesignMode.RealSubject");
        subject.eat();
    }
}
/**
 *结果 ：
 * prepare foods!!!
 * eat foods!!!
 * wash dishes!!!
 */


