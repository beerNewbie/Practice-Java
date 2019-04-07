package www.hbc.printDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: Beer
 * @Date: 2019/4/7 19:07
 * @Description:
 */
class PrintUtil {
    private OutputStream out;

    public PrintUtil(OutputStream out) {
        this.out = out;
    }

    public void print(String str) {
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String str) {
        this.print(str + "\r\n");
    }

    public void print(int data) {
        this.print(String.valueOf(data));
    }

    public void println(int data) {
        this.print(data + "\r\n");
    }

    public void print(double data) {
        this.print(String.valueOf(data));
    }

    public void println(double data) {
        this.print(data + "\r\n");
    }
    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class TestPrintUtil {
    public static void main(String[] args) throws Exception{
        //1.取得File对象
        File file = new File("C:\\Users\\DELL\\Desktop\\TextIO.txt");
        //2.取得输出流
        PrintUtil print = new PrintUtil(new FileOutputStream(file));
        //3.数据输入
        print.print(10);
        print.println(20.9);
        print.println("Hello");
        //4.关闭流
        print.close();
    }
}
