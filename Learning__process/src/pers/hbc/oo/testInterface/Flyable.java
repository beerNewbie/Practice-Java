package pers.hbc.oo.testInterface;

public interface Flyable {
    int MAX_SPEED = 1100;
    int MIN_HIGHT = 1;
    void fly();
}
interface Attack {
    void attack();
}
class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("飞机依靠发动机");
    }
}
class Man implements Flyable {
    @Override
    public void fly() {
        System.out.println("竹蜻蜓飞");
    }
}
class Stone implements Flyable,Attack {
    int weight;
    @Override
    public void fly() {
        System.out.println("扔起来飞");
    }

    @Override
    public void attack() {
        System.out.println("石头攻击");
    }
}
