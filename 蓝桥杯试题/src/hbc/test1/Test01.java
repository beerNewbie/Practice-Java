package hbc.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 任意一个5位数，比如：34256，把它的各位数字打乱，重新排列，可以得到一个最大的数：65432，一个最小
 * 的数23456。求这两个数字的差，得：41976，把这个数字再次重复上述过程（如果不足5位，则前边补0）。如
 * 此往复，数字会落入某个循环圈（称为数字黑洞）。
 * 比如，刚才的数字会落入：[82962, 75933, 63954, 61974] 这个循环圈。
 *
 * 请编写程序，找到5位数所有可能的循环圈，并输出，每个循环圈占1行。其中5位数全都相同则循环圈为 [0]，这个可以不考虑。
 *
 * 循环圈的输出格式仿照：
 * [82962, 75933, 63954, 61974]
 *
 * 其中数字的先后顺序可以不考虑。
 */
public class Test01 {
    //保存数字环//    private static List<List<Integer>> allList = new ArrayList<List<Integer>>();
    private static List<List<Integer>> allList = new ArrayList<List<Integer>>();

    //生成下一个黑洞数
    private static int getNext(int n) {
        char[] temp = (n+"").toCharArray();//ToCharArray( )的用法，将字符串对象中的字符转换为一个字符数组。
        Arrays.sort(temp);//拆分后进行升序排列
        String num = String.valueOf(temp);//将字符数组转化为字符串
        int min = Integer.parseInt(num);//parseInt的返回值只有两种可能，不是一个十进制整数，就是NaN(非数)。
        //将最小值逆序
        int max = Integer.parseInt(new StringBuilder(num).reverse().toString());
        return max-min;
    }

    public static void main(String[] args) {
        //穷举所有可能的五位数
        for(int a=0;a<=9;a++) {
            for(int b=0;b<=a;b++) {
                for(int c=0;c<=b;c++) {
                    for(int d=0;d<=c;d++) {
                        for(int e=0;e<=d;e++) {
                            int temp = a*10000+b*1000+c*100+d*10+e;
                            List<Integer> list = findRing(temp);
                            if(list!=null) {
                                allList.add(list);
                            }
                        }
                    }
                }
            }
        }
        show();
    }
    //利用该数字找环
    private static List<Integer> findRing(int num) {
        //一个记录黑洞数产生过程的数字序列
        List<Integer> list = new ArrayList<Integer>();
        int temp = num;
        while(true) {
            temp = getNext(temp);
            //该环存在则返回空
            if(temp==0||exist(temp)) {
                return null;
            }
            //判断该数生成的数字序列是否已经存在
            int index = list.indexOf(temp);
            if(index!=-1) {
                //把形成环的部分截取出来
                return list.subList(index, list.size());
            }else {
                //将该数字加到数字序列中
                list.add(temp);
            }
        }
    }

    //判断该数字是否存在环中
    private static boolean exist(int temp) {
        for(List list:allList) {
            if(list.contains(temp)) {
                return true;
            }
        }
        return false;
    }

    //将所有数字环输出
    private static void show() {
        for(List<Integer> list:allList) {
            System.out.print("[");
            for(int i=0;i<list.size()-1;++i) {
                System.out.print(list.get(i)+",");
            }
            System.out.print(list.get(list.size()-1));
            System.out.println("]");
        }
    }

}
/**
 [74943, 62964, 71973, 83952]
 [63954, 61974, 82962, 75933]
 [53955, 59994]
 */