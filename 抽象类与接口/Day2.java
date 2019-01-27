//抽象基类实现
//abstract class CaffeineBeverage {
//    final void prepareRecipe() {
//        boilWater();
//        brew();
//        pourIncup();
//        addCondiments();
//    }
//    abstract void brew();
//    abstract void addCondiments();
//    void boilWater() {
//        System.out.println("Boiling water");
//    }
//    void pourIncup() {
//        System.out.println("Pouring into cup");
//    }
//}
//class Tea extends CaffeineBeverage {
//    void brew() {
//        System.out.println("Steeping the tea");//steep:浸泡
//    }
//    void  addCondiments() {
//        System.out.println("Adding lemon");
//    }
//}
//class Coffee extends CaffeineBeverage {
//    void brew() {
//        System.out.println("Dripping coffee through filter");//drip:使滴下；filter:过滤
//    }
//    void addCondiments() {
//        System.out.println("Adding milk and sugar");
//    }
//}
//
//public class Day1 {
//    public static void main(String[] args) {
//        CaffeineBeverage tea = new Tea();
//        CaffeineBeverage coffee = new Coffee();
//        tea.prepareRecipe();
//        coffee.prepareRecipe();
//    }
//}
//扩展，引入“钩子方法”
abstract class CaffeineBeverage {
    final void prepareRecipe() {
        boilWater();
        brew();
        pourIncup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }
    abstract void brew();
    abstract void addCondiments();
    void boilWater() {
        System.out.println("Boiling water");
    }
    void pourIncup() {
        System.out.println("Pouring into cup");
    }
    //钩子方法，超类中通常默认实现，子类可以选择性的覆写此方法
    boolean customerWantsCondiments() {
        return true;
    }
}
class Tea extends CaffeineBeverage {
    void brew() {
        System.out.println("Steeping the tea");//steep:浸泡
    }
    void  addCondiments() {
        System.out.println("Adding lemon");
    }

}
class Coffee extends CaffeineBeverage {
    void brew() {
        System.out.println("Dripping coffee through filter");//drip:使滴下；filter:过滤
    }
    void addCondiments() {
        System.out.println("Adding milk and sugar");
    }
    //子类覆写钩子函数，实现自定义功能
    public boolean customerWantsCondiments() {
        String answer = getUserInput();
        if (answer.equals("y")) {
            return true;
        }else {
            return false;
        }
    }
    private String getUserInput() {
        String answer = null;
        System.out.println("您要在咖啡中加糖或牛奶吗？（y/n）");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }
}

public class Day1 {
    public static void main(String[] args) {
        CaffeineBeverage tea = new Tea();
        CaffeineBeverage coffee = new Coffee();
        System.out.println("\nMaking tea:");
        tea.prepareRecipe();
        System.out.println("\nMaking coffee:");
        coffee.prepareRecipe();
    }
}
