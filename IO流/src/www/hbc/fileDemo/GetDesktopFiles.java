package www.hbc.fileDemo;

import java.io.File;

/**
 * @Author: Beer
 * @Date: 2019/4/5 16:55
 * @Description:
 *
 * 判断File对象是否是文件
 * public boolean isFile()
 * 判断File对象是否是文件夹
 * public boolean isDirectory()
 * 取得文件大小-字节为单位（xx/1024就是多少kb）
 * public long length()
 * 取得上次修改时间
 * public long lastModified()
 * 列出一个目录的全部组成
 * public File[] listFiles()
 */
public class GetDesktopFiles {
    public static void main(String[] args) {
        //1.取得File对象
        File file = new File("C:"+File.separator+"Users"+File.separator+
                "DELL"+File.separator+"Desktop");
        listAllFiles(file);
    }
    public static void listAllFiles(File file) {//直接用void即可
        //1.判断是否是文件
        if (file.isFile()) {
            System.out.println(file);
        }
        //2.判断文件是否存在并且是否是文件夹
        if (file.exists() && file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                listAllFiles(file1);
            }
        }
    }
}
