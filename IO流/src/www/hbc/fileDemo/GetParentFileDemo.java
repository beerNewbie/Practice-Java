package www.hbc.fileDemo;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Beer
 * @Date: 2019/4/5 16:37
 * @Description:
 *
 * 取得父路径的File对象
 * public File getParentFile()
 * 取得父路径的目录
 * public String getParent()
 * 创建多级父路径（一次性创建多级不存在的父路径）
 * public boolean mkdirs()
 */
public class GetParentFileDemo {
    public static void main(String[] args) {
        //1.取得File对象
        File file = new File("C:"+File.separator+"Users"+
                File.separator+"Dell"+File.separator+"Desktop"+File.separator+
                "www"+File.separator+"hbc"+File.separator+"demo"+File.separator+"Test.java");
        //2.判断父路径是否存在
        if (!file.getParentFile().exists()) {
            //不存在时创造多级父路径
            file.getParentFile().mkdirs();
        }
        //3.判断文件是否存在
        if (file.exists()) {
            System.out.println("文件已存在");
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
