package Java核心技术卷代码练习.SIxth.InnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


/**
 * @Author: Beer
 * @Date: 2019/8/5 0:34
 * @Description:
 */
public class Test01 {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(5000,true);
        clock.start();
        JOptionPane.showMessageDialog(null,"结束程序吗？？");
        System.exit(0);
    }
}
class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        ActionListener listener = new TimePrinter();
        Timer t = new javax.swing.Timer(interval,listener);
        t.start();
    }

    public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
