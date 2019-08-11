package Java核心技术卷代码练习.泛型程序设计.泛型类型.消除受查异常实例;


import java.io.File;
import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/8/12 0:21
 * @Description: 将必须捕获的受查异常“包装”为非受查异常
 */

public class Test {
    public static void main(String[] args) {
        new Block() {
            public void body() throws Exception {
                Scanner in = new Scanner(new File("NotExit","UTF-8"));
                while (in.hasNext()) {
                    System.out.println(in.next());
                }
            }
        }.toThread().start();
    }
}
