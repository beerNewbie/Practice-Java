package com.hbc.singleThreadVersion;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/7/26 22:12
 * @Description:
 *
 *      客户端：
 */
public class SingleThreaClient {
    public static void main(String[] args) throws Exception{
        //1.建立连接
        Socket socket = new Socket("127.0.0.1",8888);
        //2.进行数据的输入输出
        Scanner scanner = new Scanner(socket.getInputStream());
        if (scanner.hasNext()) {
            System.out.println("服务器端说：" + scanner.nextLine());
        }
        PrintStream printStream =
                new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("我是客户端。");
        //3.关闭流
        socket.close();
        printStream.close();
        scanner.close();
    }
}
