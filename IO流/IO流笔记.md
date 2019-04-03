### JavaIO-BIO（阻塞式IO）-基于抽象类
#### 核心掌握五个类（ [File、OutputStream、InputStream、Reader、Writer]()）+ 一个接口（[Serializable]()）
##### 1.File文件操作类-既可以描述具体文件也可描述文件夹
- [ ] File类是唯一一个与文件操作（创建、删除、取得信息）有关的程序类
- [ ] 产生File对象：
- public File(String pathname):根据文件的绝对路径来产生File对象
- public File(URI uri) : 根据网络产生File对象
###### 1.1常用操作方法
- [ ] 创建新文件：
- public boolean creatNewFile() throws IOException
- [ ] 判断文件是否存在
- public boolean exists()
- [ ] 删除文件
- public boolean delete()
- [ ] 文件分隔符:File.separator
```
//eg:
public class Test {
    public static void main(String[] args) {
        //1.取得File对象
        File file = new File("C:"+File.separator+"Users"+File.separator+
            "DELL"+File.separator+"Desktop"+File.separator+"Test.java");
        //2、判断是否存在
        if (file.exists()) {
            file.delete();
        }else {
            try {
                file.creatNewFile();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```
###### 1.2目录操作
- [ ] 取得父路径的File对象
- public File getParentFile()
- [ ] 取得父路径的目录
- public String getParent()
- [ ] 创建多级父路径（一次性创建多级不存在的父路径）
- public boolean mkdirs()
```
//eg:
public class Test {
    public static void main(String[] args) {
        //1.取得File对象
        File file = new File("C:"+File.separator+"Users"+File.separator+
            "DELL"+File.separator+"Desktop"+File.separator+"www"+
            File.separator+"hbc"+File.separator+"Test.java");
        //2、判断父路径是否存在，不存在创建多级父路径
        if (！file.getParentFile.exists()) {
            file.getParentFile().mkdirs();
        }
        //判断文件是否存在，不存在则创建文件
        if(file.exists()) {
            System.out.println("文件已存在");
        }else {
            try {
                file.creatNewFile();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```
###### 1.3取得文件信息
- [ ] 判断File对象是否是文件
- public boolean isFile()
- [ ] 判断File对象是否是文件夹
- public boolean isDirectory()
- [ ] 取得文件大小-字节为单位（xx/1024就是多少kb）
- public long length()
- [ ] 取得上次修改时间
- public long lastModified()
- [ ] 列出一个目录的全部组成
- public File[] listFiles()
```
//eg:获取桌面上的所有文件
public class Test {
    public static void main(String[] args) {
        //1.取得File对象
        File file = new File("C:"+File.separator+"Users"+File.separator+
            "DELL"+File.separator+"Desktop");
        //将IO操作放在子线程中
        new Thread(() ->{
            listAllFiles(file);
        }).start();
    }
    public static void listAllFiles(File file) {
        if(file.isFile()) {
            System.out.println(file);
        }else {
            if(file.exists() && file.isDirectory()) {
                File[] file1 = file.listFiles();
                for(File file1 : files) {
                    listAllFiles(file1);
                }
            }
        }
    }
}
```
##### 2.字节与字符流
[java.io包流分为两类：输入流与输出流]()
###### 字节(byte)流:原生操作，无需转换,可以处理文本文件、图像、音乐、视频等资源[InputStream OutputStream]()
###### 字符(char)流：是经过处理后的操作，只用于处理中文文本  [Reader Writer]()
###### 流模型的操作流程：
- 1、取得终端对象
- 2、根据终端对象取得输入输出流
- 3、根据输入输出流进行数据读取与写入
- 4、关闭流
- [ ] **IO操作属于资源处理，所有的资源处理（IO操作、数据库操作、网络操作）在使用后一定要关闭**

###### 2.1字节输出流OutputStream
[public abstract class OutputStream implements Closeable, Flushable]()

- [ ] 核心方法
- public void write(byte b[]) throws IOExceptiion:将给定的字节数组全部输出
- public void write(byte b[], int off, int len) throws IOException:将给定的字节数组以off位置开始输出len长度后停止输出
- public abstract void write(int b) throws IOException:输出单个字节
- [ ] 使用OutputStream输出数据时，若指定文件不存在，FileOutputStream会自动创建文件（不包括创建目录）
- [ ] 使用FileOutputStream输出内容时，默认文件内容的覆盖操作。
- [ ] 若要进行文件内容追加，使用如下构造方法：
- public FileOutputStream(File file, boolean append)
- [ ] JDK1.7追加了AutoCloseable自动关闭接口，要使用此接口，必须使用try-catch块
```
//eg:
public class Test {
    public static void main(String[] args) {
        //1.取得终端对象
        File file = new File("C:"+File.separator+"Users"+File.separator+
            "DELL"+File.separator+"Desktop"+File.separator+"Test.txt");
        //2.取得指定文件的输出流
        OutputStresm out = new FileOutputStream(file,true);
        //3.进行 数据的输出
        String str = "Hello world";
        out.write(str.getBytes(),6,5);//getBytes()是将String类型的字符串转换为byte型并放入一个byte数组
        //4.关闭流
        out.close();
        
    }
}
```
###### 2.2 字节输入流InputStream
[public abstract class InputStream implements Closeable]()
- [ ] 将读取的内容放入字节数组中
- public int read(byte b[]) throws IOException
- [ ] 返回值有如下三种情况：
- 1.返回b.length：未读取的数据大于存放的缓冲区大小，返回字节数组大小
- 2.返回大于0的整数，此整数小于b.length：此时未读取的数据小于存放的缓冲区大小，返回剩余数据大小
- 3.返回-1：此时数据已经读取完毕（终止标记）
```
//eg:
public class Test {
    public static void main(String[] args) {
        //1.取得终端对象
        File file = new File("C:"+File.separator+"Users"+File.separator+
            "DELL"+File.separator+"Desktop"+File.separator+"Test.txt");
        //2.取得相应的输入流
        InputStresm in = new FileIntputStream(file);
        //3.进行 数据的读取
        byte[] data = new byte[1024];
        int len = in.read(data);
        System.out.println(new String(data,0,len));
        //4.关闭流
        in.close();
    }
}
```
###### 2.3 字符输出流Writer-适用于处理中文文本
[public void writer(String str) throws IOException]()
- [ ] 字符流可以直接支持字符串的输出
- [ ] 字符流若未关闭，数据在缓冲区存放，不会输出到目标终端。要想将数据输出，要么将输出流关闭，要么使用flush强制刷新缓冲区
###### 2.4 字符输入流Reader
[public int read(char cbuf[]) throws IOException]()
##### 3.转换流（字节流-> 字符流）
- [ ] **OutputStreamWriter** (字节输出流->字符输出流)
- [ ] **InputStreamReader** (字节输入流->字符输入流)
- [ ] 字符流的具体子类大都是通过转换流将字节流转换为字符流（eg：FileWriter继承转换流）
```
//实现文件的拷贝
public class Test {
    public static void main(String[] args) throws Exception{
        //源文件路径
        String sourceFilePath = "";
        //目标文件路径
        String destFilePath = "";
        copyFlie(sourceFilePath,destFilePath);
    }
    public static void copyFile(String sourceFilePath,String destFilePath) throws Exception {
        //1.取得源文件与目标文件的File对象
        File sourceFile = new File(souceFilePath);
        File destFile = new File(destFilePath);
        //2.取得输入输出流
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutStream(destFile);
        //3.数据输入输出
        int len = 0;
        byte[] data = new byte[1024];
        while((len = in.read(data)) != -1) {
            out.write(data,o,len);
        }
    }
}
```
##### 4.字符编码
###### 1.GBK、GB2312：
- [ ] GBK包含简体与繁体中文，GB2312只包含简体中文
###### 2.UNICODE：
- [ ] java 提供的16进制编码，可以描述世界上任意语言，但是编码进制太高，编码体积较大。
###### 3.ISO-8859-1：
- [ ] 国际通用编码，不支持中文，浏览器默认编码。
###### 4.UTF编码：
- [ ] 结合UNICODE与ISO-8859-1，最常采用的是UTF-8编码。
---
- [ ] 乱码产生原因：
- 编解码不一致（95%）
- 由于数据丢失造成的乱码（5%）
##### 5.内存流（以内存为终端的输入输出流）
###### 字节内存流
[ByteArrayInputStream、ByteArrayOutputStream]()
###### 字符内存流
[CharArrayReader、CharArrayWrier]()
