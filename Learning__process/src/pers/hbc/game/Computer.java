package demo.game;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/4/6 14:48
 * @Description:
 */
public class Computer {
    private int sore;
    private String name;

    public Computer(String name) {
        this.name = name;
    }

    public int getSore() {
        return sore;
    }

    public void addSore() {
        this.sore++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String first() {
        //System.out.println("Computer:");
        int i = new Random().nextInt(3);
        String str = null;
//        if (i == 0) return "石头 ";
//        else if (i == 1) return "剪刀";
//        else return "布";
        switch (i) {
            case 0:
                System.out.println(name+":出石头");
                str = "石头";
                break;
            case 1:
                System.out.println(name+":出剪刀");
                str = "剪刀";
                break;
            case 2:
                System.out.println(name+":出布");
                str = "布";
        }
        return str;
    }

}
