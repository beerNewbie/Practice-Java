//字符与字符数组


// public class Test {
//     public static void main(String[] args) {
//         String str = "hello";
//         System.out.println(str.charAt(1));
//         char[] data = str.toCharArray();
//         for (int i=0; i<data.length; i++) {
//             //data[i] -= 32;
//             System.out.print(data[i] + "、");
//         }
//         System.out.println(new String(data));
//         System.out.println(new String(data, 1, 3));//String(数组名，起始位置，长度)
//     }
// }

//判断一个字符串是否由数字组成
// public class Test {
//     public  static void main(String[] args) {
//         String str = "123789";
//         System.out.println(isNumble(str)?"字符串由数字组成":"字符串中有非数字成员");
//     }
//     public static boolean isNumble(String str) {
//         char[] data = str.toCharArray();
//         for (int i=0; i<data.length; i++) {
//             if (data[i]<'0'||data[i]>'9') {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

//字符串比较
// public class Test {
//     public static void main(String[] args) {
//         String str1 = "Hello";
//         String str2 = "hello";
//         System.out.println(str1.equals(str2));
//         System.out.println(str1.equalsIgnoreCase(str2));//不区分大小写

//         System.out.println("A".compareTo("a"));//小于0
//         System.out.println("p".compareTo("B"));//大于0
//         System.out.println("p".compareTo("p"));//等于0
//     }
// }

//字符串查找
// public class Test {
//     public static void main(String[] args) {
//         String str = "helloworld";
//         System.out.println(str.contains("world"));//true
//         System.out.println(str.indexOf("orld"));//6
//         if (str.indexOf("hello") != -1) {
//             System.out.println("可以找到指定字符");
//         }
//         System.out.println(str.indexOf("l", 5));//8
//         System.out.println(str.lastIndexOf("l"));//8
//         //indexOf():从头开始查找指定字符串的位置，查到了返回字符串的位置的开始索引，查不到返回-1
//         //如果内容重复，他只能返回查找的第一个位置
//     }
// }

//字符串替换
// public class Test {
//     public static void main(String[] args) {
//         String str = "hello";
//         System.out.println(str.replaceAll("l", "*"));//替换所有指定内容
//         System.out.println(str.replaceFirst("l", "*"));//替换首个内容
//     }
// }

//字符串拆分
// public class Test {
//     public static void main(String[] args) {
//         // String str = "hello world hello everyone";
//         // String[] result = str.split(" ",4);
//         // for (String s : result) {
//         //     System.out.println(s);
//         // }
//         // String str1 = "192.168.1.1";//拆分IP地址
//         // String[] result1 =  str1.split("\\.");//若拆分的结果为空，指定字符串内容需要 转义\\
//         // for (String s : result1) {
//         //     System.out.println(s);
//         // }
//         String str = "李华:27|张三:19";//多次拆分
//         String[] result = str.split("\\|");
//         for (int i=0; i<result.length; i++) {
//             String[] temp = result[i].split(":");
//             System.out.println(temp[0]+"="+temp[1]);
//         }
//     }
// }

//字符串截取
// public class Test {
//     public static void main(String[] args) {
//         String str = "helloworld";
//         System.out.println(str.substring(5));//从指定索引到结尾
//         System.out.println(str.substring(0,5));//截取部分
//     }
// }

//public String trim()  去掉字符串的左右空格，保留中间空格
// public class Test {
//     public static  void main(String[] args) {
//         String str = "   112 343 ";
//         System.out.println("["+str+"]");
//         System.out.println("["+str.trim()+"]");
//     }
// }

//大小写转换
// public class Test {
//     public static void main(String[] args) {
//         String str = "  saiuBNHbbha很好吃@#@ ";
//         System.out.println(str.toUpperCase());
//         System.out.println(str.toLowerCase());
//         System.out.println(str.length());//数组长度使用数组名称.length属性，而String中使用的是length()方法
//         System.out.println(new String().isEmpty());//true
//     }
// }

//首字母大写
public class Test {
    public static void main(String[] args) {
        System.out.println(firstUpper("hello"));
        System.out.println(firstUpper(""));
        System.out.println(firstUpper(" hello"));
    }
    public static String firstUpper(String str) {
        if ("".equals(str)||str==null) {
            return str;
        }
        if (str.length()>1) {
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
        return str.toUpperCase();
    }
}
