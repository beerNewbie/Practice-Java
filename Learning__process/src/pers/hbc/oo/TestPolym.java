package pers.hbc.oo;

public class TestPolym {
    public static void main(String[] args) {
        Animal a = new Animal();
        animalShout(a);
        Animal g = new Dog();//自动 向上转型
        animalShout(g);
        Dog g2 = (Dog)g;//强制向下转型
        g2.protectDoor();
    }
    static void animalShout(Animal a) {
        a.shout();
    }
}
class Animal {
    public void shout() {
        System.out.println("叫了一声");
    }
}
class Dog extends Animal {
    public void shout() {
        System.out.println("汪汪汪");
    }
    public void protectDoor() {
        System.out.println("看门");
    }
}
class Cat extends Animal {
    public void shout() {
        System.out.println("喵喵喵");
    }
}
