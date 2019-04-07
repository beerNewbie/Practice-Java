package www.hbc.ScannerDemo;

import java.util.Scanner;

/**
 * @Author: Beer
 * @Date: 2019/4/7 20:35
 * @Description:
 */
public class TestScanner {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入出生日期:");
        scanner.useDelimiter("\n");//以回车为分隔符
        if (scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("出生日期为：" + scanner.next());
        }
    }
}
/**
 * 结果：
 * 请输入出生日期:
 * 2019-01-01
 * 出生日期为：2019-01-01
 *输入错误则：
 * 请输入出生日期:
 * 2019-1-1
 *
 * Process finished with exit code 0
 */

