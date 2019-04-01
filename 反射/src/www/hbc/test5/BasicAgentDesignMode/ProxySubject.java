package www.hbc.test5.BasicAgentDesignMode;

/**
 * @Author: Beer
 * @Date: 2019/4/1 23:42
 * @Description:
 */
class ProxySubject implements ISubject{
    private ISubject subject;

    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }

    public void prepare() {
        System.out.println("prepare foods!!!");
    }

    public void finishEating() {
        System.out.println("wash dishes!!!");
    }

    @Override
    public void eat() {
        this.prepare();
        this.subject.eat();
        this.finishEating();
    }
}
