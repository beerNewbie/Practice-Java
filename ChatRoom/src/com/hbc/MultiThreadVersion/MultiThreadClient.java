package com.hbc.MultiThreadVersion;

/**
 * @Author: Beer
 * @Date: 2019/7/26 23:00
 * @Description:
 */

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 读取服务器发来消息的线程
 */
class ReadFromServer implements Runnable {
    private Socket client;

    public ReadFromServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        //通过输入流来取得服务器发来的消息
        try {
            Scanner in = new Scanner(client.getInputStream());
            while (true) {
                if (client.isClosed()) {
                    System.out.println("客户端已关闭！");
                    break;
                }
                if (in.hasNext()) {
                    String msgFromServer = in.nextLine();
                    System.out.println("服务器说：" + msgFromServer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 向服务器发送信息线程
 */
class SendMagToServer implements Runnable {
    private Socket client;

    public SendMagToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //获取输出流，向服务器发送信息
            PrintStream printStream =
                    new PrintStream(client.getOutputStream(),true,"UTF-8");
            //获取用户输入
            Scanner in = new Scanner(System.in);
            while (true) {
                System.out.println("请输入信息：");
                String strFromUser = "";
                if (in.hasNext()) {
                    strFromUser = in.nextLine();
                }
                //像服务器发送信息
                printStream.println(strFromUser);
                //判断字符串包含”再见“时，退出
                if (strFromUser.contains("再见")) {
                    System.out.println("客户端退出聊天室");
                    printStream.close();
                    in.close();
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class MultiThreadClient {
    public static void main(String[] args) throws Exception{
        //根据指定IP和端口号进行连接
        Socket client = new Socket("127.0.0.1",8888);
        //启动读线程与写线程
        Thread readThread = new Thread(new ReadFromServer(client));
        Thread sendThread = new Thread(new SendMagToServer(client));
        readThread.start();
        sendThread.start();
    }
}
