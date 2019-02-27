package pers.hbc.oo.abstractClass;

/**
 * 1.有抽象方法的类只能定义抽象类
 * 2.抽象类不能实例化，不能用new来实例化抽象类
 * 3.抽象类可以包含属性、方法、构造方法。但是构造方法不能用来new实例，只能被子类调用
 * 4.抽象类只能用来继承
 * 5.抽象方法必须被子类实现
 * 抽象方法的意义：将方法的设计与实现分离了
 */

public abstract class Animal {
    String str;
    public void breath() {
        System.out.println("呼吸");
        run();//实际是调子类
    }
    public abstract void run();
}
class Cat extends Animal {
    public void run() {
        System.out.println("猫：小跑");
    }
}
class Dog extends Animal {
    public void run() {
        System.out.println("狗：摇尾巴跑");
    }
}
