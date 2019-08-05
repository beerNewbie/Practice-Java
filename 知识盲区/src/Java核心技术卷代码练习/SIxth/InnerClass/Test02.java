package Java核心技术卷代码练习.SIxth.InnerClass;


/**
 * @Author: Beer
 * @Date: 2019/8/5 22:47
 * @Description:
 */

public class Test02 {
    public static void main(String[] args) {
        Outter outter = new Outter();
        outter.addAge(2);

    }
}

class Outter {
    private static int defaultAge = 20;
    public static void addAge(int age) {
       class  NewAge {
            private int getAge() {
                return age + defaultAge;
            }
        }
        NewAge newAge = new NewAge();
        System.out.println(newAge.getAge());
    }
}
