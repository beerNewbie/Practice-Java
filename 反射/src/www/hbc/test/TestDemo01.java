package www.hbc.test;

/**
 * @Author: Beer
 * @Date: 2019/3/17 16:06
 * @Description:工厂模式与反射
 */
interface IComputer {//redundent:多余的
    void buyComputer() ;
}
class Mac implements IComputer {
    @Override
    public void buyComputer() {
        System.out.println("秒一台苹果");
    }
}
class Surface implements IComputer {
    @Override
    public void buyComputer() {
        System.out.println("秒一台微软");
    }
}
class ComuterFactoy {
    private ComuterFactoy() {}
    public static IComputer getInstance(String className) {
        IComputer computer = null;
        try {
            computer = (IComputer) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return computer;

    }
}
public class TestDemo01 {
    public static void main(String[] args) {
        IComputer computer =
                ComuterFactoy.getInstance("www.hbc.test.Mac");
        computer.buyComputer();
    }
}
