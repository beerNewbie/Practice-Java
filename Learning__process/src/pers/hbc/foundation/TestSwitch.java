package pers.hbc.foundation;

public class TestSwitch {
    public static void main(String[] args) {
        char c = 'a';
        int rand = (int)(26*(Math.random()));
        char letter = (char)(c+rand);
        System.out.printf(letter+":");
        switch(letter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("元音字母");
                break;
            case 'y':
            case 'w':
                System.out.println("半辅音字母");
                break;
            default:
                System.out.println("辅音字母");
        }
        /**
         * 1.如果判别式中有break，执行完跳出switch，若没有则会一直执行到有break或switch结束
         * 2.defaul在switch开头：
         *         若所有 case都不满足时，则执行default，并执行default后的case语句直到break 或 结束
         * 3.default在switch中间：
         *          同2；
         */
    }
}
