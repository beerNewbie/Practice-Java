package www.hbc.byteAndCharStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Beer
 * @Date: 2019/4/6 14:00
 * @Description:
 *
 * 将读取的内容放入字节数组中
 * public int read(byte b[]) throws IOException
 * 返回值有如下三种情况：
 * 1.返回b.length：未读取的数据大于存放的缓冲区大小，返回字节数组大小
 * 2.返回大于0的整数，此整数小于b.length：此时未读取的数据小于存放的缓冲区大小，返回剩余数据大小
 * 3.返回-1：此时数据已经读取完毕（终止标记）
 */
public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        //1.取得终端
        File file = new File("C:"+File.separator+"Users"+File.separator+
                "DELL"+File.separator+"Desktop"+File.separator+"Test.txt");
        //2.取得输入流
        InputStream in = new FileInputStream(file);
        //3.进行数据读取
        int len = -1;
        byte[] data = new byte[2];
//        String str = null;
        while((len = in.read(data)) != -1){
          String str = new String(data,0,len);
            System.out.print(str);
        }
        in.close();
    }

}
