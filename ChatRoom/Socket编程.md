## Socket编程

#### 服务器端



#### 客户端

- [ ] 客户端连接服务器时需要指定服务器的IP（标识电脑）与端口号（标识电脑上的某个具体应用）





### 单线程下

#### ServerSocket：基站类，服务器Socket类

- [ ] **public ServerSocket(int port) : 在本机根据指定端口号创建服务器**
- [ ] **public Socket accept() : 侦听并接收连接到本服务的客户端连接。此方法会一直阻塞，直到有一个客户端成功连接，返回此连接**



#### Socket：客户端类

- [ ] **public Socket(String host, int port) : 根据指定ip和端口号创建套接字并连接到远程服务器端**
- [ ] **public InptStream getInputStream() ：返回此套接字的输入流**
- [ ] **public OutputStream getOutputStream() ：返回此套接字的输出流**

------

```java
//服务器端
public class SingleThreadServer {
    public static void main(String[] args) throws Exception {
        //1.建立基站
        ServerSocket server = new ServerSocket(8888);
        //2.等待客户端连接
        System.out.println("等待客户端连接。。。")
         Socket socket = sever.accept();
        //3.建立连接后进行数据的输入输出
         PrintStream printStream = new PrintStream(
         	socket.getOutputStream(), true, "UTF-8");
        printStream.println("这是服务器，这是服务器，收到请回答");
        Scanner sc = new Scanner(socket.getInputStream());
        if (sc.hasNext()) {
            System.out.println("客户端发来的信息为" + sc.nextLine());
        }
        //4.关闭流
        sc.close();
        printStream.close();
        server.close();
    }
}
```



```java
//客户端
public class SingleThreadClient {
    public static void main(String[] args) throws Exception {
        //1.建立连接
        Socket socket = new Socket("127.0.0.1", 8888);
        //2.进行数据的输入输出
        Scanner scanner = new Scanner(socket.getInputStream());
        if (scanner.hasNext()) {
            System.out.println("从服务器发来的信息为：" + scanner.nextLine());
        }
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("这是客户端，这是客户端");
        //3.关闭流
        printStream.close();
        scanner.close();
        socket.close();
    }
}
```



### 多线程下：

#### 客户端：

##### 读取服务器信息--读线程

##### 向服务器发送信息--写线程

```java
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
```



#### 服务器：

##### 要能接收多个客户端的连接请求--多线程，线程池

##### 如何保存多个客户端的连接---Map实现----->ConcurrentHashMap(保证多线程注册时用户名唯一)

> 规则：注册：userName：Beer
>
> ​		   群聊：G:群聊内容
>
> ​           私聊：P:用户名：私聊内容
>
> ​		   退出：Beer：再见

```java
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

```

