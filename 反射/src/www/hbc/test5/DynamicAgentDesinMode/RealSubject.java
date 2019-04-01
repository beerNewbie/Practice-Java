package www.hbc.test5.DynamicAgentDesinMode;

/**
 * @Author: Beer
 * @Date: 2019/4/2 0:33
 * @Description:
 */
class RealSubject implements ISubject{
    @Override
    public void eat(String msg, int num) {
        System.out.println("I want to eat " + num +" sizes' " + msg);
    }
}
