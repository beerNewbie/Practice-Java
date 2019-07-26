package com.hbc.MultiThreadVersion;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Beer
 * @Date: 2019/7/26 23:34
 * @Description:
 *
 */

public class MultiThreadServerr {
    private static Map<String, Socket> clientLists =
            new ConcurrentHashMap<>();

    /**
     * 处理每个客户端的输入输出请求
     */
    public static class ExecuteClientRequest implements Runnable {
        private Socket client;

        public ExecuteClientRequest(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            //获取用户输入流，读取用户发来的信息
            try {
                Scanner in = new Scanner(client.getInputStream());
                String strFromClient = "";
                while (true) {
                    if (in.hasNext()) {
                        strFromClient = in.nextLine();
                        //Windows消除用户自带“\r”
                        Pattern pattern = Pattern.compile("\r");
                        Matcher matcher = pattern.matcher(strFromClient);
                        strFromClient = matcher.replaceAll("");
                    }
                    //注册流程  userName:Beer
                    if (strFromClient.startsWith("userName:")) {
                        String userName = strFromClient.split("\\:")[1];
                        userRegister(userName,client);
                    }
                    //群聊流程  G:
                    if (strFromClient.startsWith("G:")) {
                        String groupMsg = strFromClient.split("\\:")[1];
                        groupChat(groupMsg);
                    }
                    //私聊流程  P:1-hello
                    if (strFromClient.startsWith("P:")) {
                        String userName =
                                strFromClient.split("\\:")[1].split("\\-")[0];
                        String privateMsg =
                                strFromClient.split("\\:")[1].split("\\-")[1];
                        privateChat(userName,privateMsg);
                    }
                    //用户退出  再见
                    if (strFromClient.contains("再见")) {
                        String userName = strFromClient.split("\\:")[0];
                        userOutLine(userName);
                        break;
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 用户注册
         * @param userName 用户名
         * @param socket 用户名对应的socket
         */
        private void userRegister(String userName, Socket socket) {
            clientLists.put(userName,socket);
            System.out.println("用户："+userName+"上线了！");
            System.out.println("当前聊天室人数为："+clientLists.size()+"人");
            try {
                PrintStream out =
                        new PrintStream(socket.getOutputStream(),true,"UTF-8");
                out.println("注册成功");
                out.println("当前聊天室人数为："+clientLists.size()+"人");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 群聊方法
         * 遍历Map，向每个客户端输出一遍
         * @param groupMsg
         */
        private void groupChat(String groupMsg) {
            Set<Map.Entry<String, Socket>> clientEntry =
                    clientLists.entrySet();
            Iterator<Map.Entry<String, Socket>> iterator =
                    clientEntry.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Socket> client = iterator.next();
                //拿到客户端输出流输出群聊信息
                try {
                    PrintStream out =
                            new PrintStream(client.getValue().getOutputStream(),true, "UTF-8");
                    out.println("群聊信息为："+groupMsg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 私聊方法
         * @param userName
         * @param privateMsg
         */
        private void privateChat(String userName,String privateMsg) {
            //取出userName对应的Socket
            Socket client = clientLists.get(userName);
            try {
                PrintStream out =
                        new PrintStream(client.getOutputStream(),true, "UTF-8");
                out.println("私聊信息为："+privateMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         *用户退出
         * @param userName
         */
        private void userOutLine(String userName) {
            //删除Map中的用户实体
            clientLists.remove(userName);
            System.out.println("用户"+userName+"已下线！");
            System.out.println("当前聊天室人数为："+clientLists.size()+"人");

        }
    }

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8888);
        ExecutorService executorService =
                Executors.newFixedThreadPool(20);
        System.out.println("等待客户端连接...");
        for (int i = 0; i < 20; i++) {
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接，端口号为："+client.getPort());
            executorService.submit(new ExecuteClientRequest(client));
        }
        //关闭线程池与客户端
        executorService.shutdown();
        serverSocket.close();
    }
}
