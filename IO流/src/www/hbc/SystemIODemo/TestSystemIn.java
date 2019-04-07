package www.hbc.SystemIODemo;

import java.io.InputStream;

/**
 * @Author: Beer
 * @Date: 2019/4/7 19:50
 * @Description:
 */
public class TestSystemIn {
    public static void main(String[] args) throws Exception{
        InputStream in = System.in;
        System.out.println("请输入内容：");
        byte[] data = new byte[1024];
        int len = 0;
        len = in.read(data);
        System.out.println("输入的内容为：\n" + new String(data,0,len));
    }
}
