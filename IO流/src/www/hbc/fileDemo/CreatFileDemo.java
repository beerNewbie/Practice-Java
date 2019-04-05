package www.hbc.fileDemo;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Beer
 * @Date: 2019/4/5 16:24
 * @Description:
 *
 * 创建新文件：
 * public boolean creatNewFile() throws IOException
 * 判断文件是否存在
 * public boolean exists()
 * 删除文件
 * public boolean delete()
 * 文件分隔符:File.separator
 */

public class CreatFileDemo {
    public static void main(String[] args) {
        //1.取得File对象
        File file = new File("C:"+File.separator+"Users"+
                File.separator+"Dell"+File.separator+"Desktop"+File.separator+"Test.java");
        //2.判断是否存在
        if (file.exists()) {
            file.delete();
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
