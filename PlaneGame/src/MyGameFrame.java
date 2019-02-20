
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

//飞机的游戏窗口

public class MyGameFrame extends Frame{

    Image planeImg = GameUtil.getImage("images/airplane.png");
    Image bg = GameUtil.getImage("images/background.png");

    Plane plane = new Plane(planeImg,250,350);
    Shell[] shells = new Shell[20];

    Explode explode;
    Date startTime = new Date();
    Date endTime;
    int period;//游戏持续时间
    @Override
    public void paint(Graphics g) {//自动被调用。g相当于一支画笔
        super.paint(g);
        /**
         *    黑屏原因：setVisible(true)窗口可见已自动调用paint函数，
         * setSize()改变了窗口大小又会自动调用paint函数，paint函数
         * 会默认清空之前的绘制
         * 解决办法：加super.pait(g)或把可视化移下
         */
        Color c = g.getColor();
        g.drawImage(bg,0,0,null);
        plane.drawSelf(g);//画飞机

        //画出所有炮弹
        for(int i=0;i<shells.length;i++) {
            shells[i].draw(g);

          //飞机和炮弹 碰撞检测
          boolean peng = shells[i].getRect().intersects(plane.getRect());
          if(peng) {
              plane.live = false;
              if(explode==null){
                  explode = new Explode(plane.x,plane.y);
                  endTime = new Date();

                  period = (int)((endTime.getTime()-startTime.getTime())/1000);
              }
              explode.draw(g);
          }

          if(!plane.live) {
              Font f = new Font("宋体",Font.BOLD,20);
              g.setFont(f);
              g.setColor(Color.white);
              g.drawString("时间：" + period + "秒", (int) plane.x, (int) plane.y);
          }
        }g.setColor(c);

    }

    class PaintThread extends Thread{
        @Override
        public void run() {
            while(true) {
                System.out.println("窗口被重画");
                repaint();//重画

                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //定义键盘监听的内部类
    class KeyMonitor extends KeyAdapter {//快捷键：重写方法 Ctrl+O

        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }

    //初始化 窗口
    public void launchFrame() {
        this.setTitle("飞机小游戏");
        this.setVisible(true);//可见
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//设置大小
        this.setLocation(200,200);//设置位置


        this.addWindowListener(new WindowAdapter() {//关闭窗口
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start();//启动重画窗口的线程
        addKeyListener(new KeyMonitor());//给窗口增加键盘的监听

        //初始化生成50个炮弹
        for(int i = 0;i<shells.length;i++) {
            shells[i] = new Shell();
        }

    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
             offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }
}
