
import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x = 150;//小球的横坐标
    double y = 150;//小球的纵坐标
   // boolean right = true;//水平方向
    double degree = 3.14/3;//弧度，60度


    //画窗口的方法
    public void paint(Graphics g) {
        System.out.println("窗口被画了一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);
//水平移动
//        if (right) {
//            x = x + 10;
//        }else {
//            x = x - 10;
//        }
//        if (x>856-40-30) {//865窗口宽度，40桌子边框宽度，30小球直径
//            right = false;
//        }
//        if (x<40) {//桌子边框宽度
//            right = true;
//        }
        x = x + 10 * Math.cos(degree);
        y = y + 10 * Math.sin(degree);

        if (y>500-40-30 || y<40+35) {
            degree = -degree;
        }

        //碰到左右边界
        if (x<40 || x>856-40-30) {
            degree = 3.14-degree;
        }

    }


    //窗口加载
    void launchFrame() {
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);

        //重画窗口,每秒25次
        while(true) {
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("实现简易的桌球小游戏");
        BallGame game = new BallGame();
        game.launchFrame();
    }
}
