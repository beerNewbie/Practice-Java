package www.hbc.byteAndCharStreamDemo;

import java.io.*;

/**
 * @Author: Beer
 * @Date: 2019/4/5 18:24
 * @Description:
 *
 * 核心方法
 * public void write(byte b[]) throws IOExceptiion:将给定的字节数组全部输出
 * public void write(byte b[], int off, int len) throws IOException:将给定的字节数组以off位置开始输出len长度后停止输出
 * public abstract void write(int b) throws IOException:输出单个字节
 * 使用OutputStream输出数据时，若指定文件不存在，FileOutputStream会自动创建文件（不包括创建目录）
 * 使用FileOutputStream输出内容时，默认文件内容的覆盖操作。
 * 若要进行文件内容追加，使用如下构造方法：
 * public FileOutputStream(File file, boolean append)
 * JDK1.7追加了AutoCloseable自动关闭接口，要使用此接口，必须使用try-catch块
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //取得终端对象
        File file = new File("C:"+File.separator+"Users"+File.separator+
                "DELL"+File.separator+"Desktop"+File.separator+"Test.txt");
        //取得指定文件的输出流
        OutputStream out = new FileOutputStream(file,true);//append追加
        //进行数据输出
        out.write("Hello".getBytes());
        //关闭流
        out.close();
    }
}
