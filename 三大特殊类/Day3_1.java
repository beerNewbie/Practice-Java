public class Test {
    public static void main(String[] args) {
       StringBuffer sb = new StringBuffer();
       sb.append("hello").append("world");
       //fun(sb);
       //System.out.println(sb);
       //System.out.println(sb.reverse());//字符串反转
        System.out.println(sb.delete(5,10).insert(5,"：你好"));//删除指定范围数据：[ )左闭右开包含开头不包含结尾
        /**
         * String、StringBuffer、StringBuilder的区别:
         * 1.String的内容不可修改，StringBuffer与StringBuilder的内容可以修改.
         * 2.StringBuffer采用同步处理，属于线程安全操作；
         * 3.StringBuilder采用异步处理，属于线程不安全操作。
         */
    }
    public  static void fun(StringBuffer temp) {
        temp.append("\n").append("www.baidu.com");
    }
}
