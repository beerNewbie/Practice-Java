package demo.game;

import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/4/6 14:48
 * @Description:
 */
public class Pepole {
    private int sore;
    private String name;

    public Pepole(String name) {
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
        System.out.println("Please input 石头，剪刀，布:");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        return str;
    }
}
