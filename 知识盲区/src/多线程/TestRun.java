package 多线程;

/**
 * @Author: Beer
 * @Date: 2019/7/8 20:53
 * @Description: 线程间的执行顺序
 */
public class TestRun {
    public static void main(String[] args) {
        Thread thread  = new Thread() {
            public void run() {
                pong();
            }
        };
        //thread.run();//结果：pongping  此时是一个普通方法，相当于函数调用，按顺序执行
        thread.start();//结果：pingpong？？或都有可能
        /*try {
            thread.sleep(1000);//结果：pongping
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.print("ping");
    }
    static void pong() {
        System.out.print("pong");
    }
}
