package demo.game;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/4/6 14:48
 * @Description:
 */
public class Game {
    private Pepole pepole;
    private Computer computer;
    public Game() {
        pepole = new Pepole("张三");
        computer = new Computer("智能人机");
    }
    public void playThreeTime() {
        int i = 0;
        while (i < 3) {
            i++;
            String strPep = pepole.first();
            String strCom = computer.first();
            if ((strCom .equals("石头" )&& strPep.equals("剪刀") ) ||
                    (strCom.equals("剪刀")  && strPep.equals("布")) ||
                    (strCom.equals("布") && strPep.equals("石头") )) {
                computer.addSore();
                System.out.println(computer.getName()+"赢一局");
            }
            else if (strCom .equals(strPep)) {
                System.out.println("平局");
            }
            else {
                pepole.addSore();
                System.out.println(pepole.getName()+"赢一局");
            }
        }
    }
    public void getResult() {
        int a = computer.getSore();
        int b = pepole.getSore();
        if (a > b) {
            System.out.println(computer.getName()+"win!");
        }
        else if (a < b) {
            System.out.println(pepole.getName()+"win!");
        }else System.out.println("All win!");
    }
    public void start() {
        while (true) {
            playThreeTime();
            getResult();
            System.out.println("Is continue?? Yes/No");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if ("Yes".equals(str)) {
                continue;
            }else {
                break;
            }
        }
    }
}
