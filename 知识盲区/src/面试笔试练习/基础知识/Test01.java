package 面试笔试练习.基础知识;


/**
 * @Author: Beer
 * @Date: 2019/8/17 9:17
 * @Description: set对成员变量的设置
 */

class Obj {
    private String str = "Hello world";
    private int id = 1;

    public void setId(int id) {
        this.id = id;
    }

    public void setStr(String str) {
        this.str = str;
    }


    @Override
    public String toString() {
        return id + "  " +str;
    }
}

public class Test01 {
    private Obj obj = new Obj();
    private int intA = 0;

    public Obj getObj() {
        return obj;
    }

    public int getIntA() {
        //intA = 10;
        return intA;
    }

    public void changeObj(Obj obj) {
        obj.setId(100);
        obj.setStr("Hi");
    }

    public void setIntA(int intA) {
        this.intA = intA;
    }

    public void changeInt(int i) {
        setIntA(200);
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println("************************");
        System.out.println("调用changeObj()之前：" + test01.getObj());
        test01.changeObj(test01.getObj());
        System.out.println("调用changeObj()之后：" + test01.getObj());
        System.out.println("*************************");
        System.out.println("调用changeInt()之前：" + test01.getIntA());
        test01.changeInt(test01.getIntA());
        System.out.println("调用changeInt()之后：" + test01.getIntA());
    }

    /**
     * ************************
     * 调用changeObj()之前：1  Hello world
     * 调用changeObj()之后：100  Hi
     * *************************
     * 调用changeInt()之前：10
     * 调用changeInt()之后：10
     *
     *
     *
     *
     * ************************
     * 调用changeObj()之前：1  Hello world
     * 调用changeObj()之后：100  Hi
     * *************************
     * 调用changeInt()之前：0
     * 调用changeInt()之后：200
     */
}
