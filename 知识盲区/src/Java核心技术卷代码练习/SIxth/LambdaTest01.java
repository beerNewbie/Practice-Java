package Java核心技术卷代码练习.SIxth;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;


/**
 * @Author: Beer
 * @Date: 2019/8/1 23:00
 * @Description: 在比较器和监听器中使用lambda表达式
 */
public class LambdaTest01 {
    public static void main(String[] args) {
        String[] planets = new String[]
                {"Mercury", "Venus", "Earth", "Mars", "Saturn"};
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets,(first,second)->first.length()-second.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event ->
                System.out.println("This time is"+new Date()));
        t.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);

    }
    /**
     * 结果：
     * [Mercury, Venus, Earth, Mars, Saturn]
     * [Earth, Mars, Mercury, Saturn, Venus]
     * Sorted by length:
     * [Mars, Earth, Venus, Saturn, Mercury]
     * This time isThu Aug 01 23:13:43 CST 2019
     * This time isThu Aug 01 23:13:44 CST 2019
     * This time isThu Aug 01 23:13:45 CST 2019
     */
}
