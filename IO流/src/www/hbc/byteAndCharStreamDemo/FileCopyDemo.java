package www.hbc.byteAndCharStreamDemo;


import java.io.*;

/**
 * @Author: Beer
 * @Date: 2019/4/6 17:33
 * @Description:
 */
public class FileCopyDemo {
    public static void main(String[] args) throws IOException {
       String sourcePath = "C:\\Users\\DELL\\Desktop\\Test.txt";
       String destpath = "C:\\Users\\DELL\\Desktop\\TestCopy.txt";
        copyFile(sourcePath, destpath);
    }

    public static void copyFile(String sourcePath, String destPath) throws IOException {
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        //取得输入输出流
        InputStream in = new FileInputStream(sourceFile);
        OutputStream out = new FileOutputStream(destFile);
        //将数据输出
        byte[] data = new byte[1024];
        int len = -1;
        while ((len = in.read(data)) != -1) {
            out.write(data, 0, len);
        }
        in.close();
        out.close();
    }
}
