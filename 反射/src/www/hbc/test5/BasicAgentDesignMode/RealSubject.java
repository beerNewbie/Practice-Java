package www.hbc.test5.BasicAgentDesignMode;

/**
 * @Author: Beer
 * @Date: 2019/4/1 23:39
 * @Description:
 */
class RealSubject implements ISubject{
    @Override
    public void eat() {
        System.out.println("eat foods!!!");
    }
}
