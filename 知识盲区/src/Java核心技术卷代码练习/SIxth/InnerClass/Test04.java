package Java核心技术卷代码练习.SIxth.InnerClass;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @Author: Beer
 * @Date: 2019/8/6 1:07
 * @Description:
 */

public class Test04 {
    public static void main(String[] args) {
        TalkingClock1 clock = new TalkingClock1(5000,true);
        clock.start();
        JOptionPane.showMessageDialog(null,"结束程序吗？？");
        System.exit(0);
    }
}
class TalkingClock1 {
    private int interval;
    private boolean beep;

    public TalkingClock1(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = e -> {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new javax.swing.Timer(interval,listener);
        t.start();
    }

}

