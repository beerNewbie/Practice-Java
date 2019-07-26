package com.hbc.singleThreadVersion;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/7/26 21:45
 * @Description: 单线程版本简易聊天室
 *
 *      服务器端
 */
public class SingleThreadServer {
    public static void main(String[] args) throws Exception{
        //1.建立基站
        ServerSocket serverSocket = new ServerSocket(8888);
        //2.等待客户端连接
        System.out.println("等待客户端连接...");
        Socket socket = serverSocket.accept();
        //3.进行数据的输入输出
        PrintStream printStream =
                new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("我是服务器！");
        Scanner scanner = new Scanner(socket.getInputStream());
        if (scanner.hasNext()) {
            System.out.println("客户端说：" + scanner.nextLine());
        }
        //4.关闭流
        serverSocket.close();
        printStream.close();
        scanner.close();
    }
}
