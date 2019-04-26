package pers.hbc.testThrowable;

/**
 * @Author: Beer
 * @Date: 2019/4/26 22:12
 * @Description: Test StackOverFlowError:递归不当
 */
public class TestSOF {
    private int len = 1;

    public void stackLeak() {
        len++;
        stackLeak();
    }

    public static void main(String[] args) {
        TestSOF testSOF = new TestSOF();
        try {
            testSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("Length = " + testSOF.len);
//            e.printStackTrace();//all right
            throw e;
        }
    }
}
