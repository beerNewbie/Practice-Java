package Java核心技术卷代码练习.泛型程序设计.泛型方法;


import java.time.LocalDate;

/**
 * @Author: Beer
 * @Date: 2019/8/13 10:51
 * @Description:
 */
class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent /100;
        salary += raise;
    }
}

class Manager extends  Employee {
    private  double bouns;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bouns = 0;
    }

    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }

    public double getBouns() {
        return bouns;
    }
}

public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Beer", 500000, 2020,6,10);
        Manager cto = new Manager("Wine",300000, 2010,12,12);
        Pair<Manager> buddies = new Pair<>(ceo,cto);
        printBuddies(buddies);

        ceo.setBouns(100000);
        cto.setBouns(50000);

        Manager[] managerss = {ceo,cto};

        Pair<Employee> result = new Pair<>();

        minmaxBonus(managerss,result);
        System.out.println("first:" + result.getFirst().getName() + ", second:" + result.getSecond().getName());
        minmaxBonus(managerss,result);
        System.out.println("first:" + result.getFirst().getName() + ", second:" + result.getSecond().getName());

    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(first.getName() + "and" + second.getName() + " are buddies!");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (min.getBouns() > a[i].getBouns()) min = a[i];
            if (max.getBouns() < a[i].getBouns()) max = a[i];
        }

        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBouns(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a,result);

    }
}

class PairAlg {
    public static boolean hasNull(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}

/*
BeerandWine are buddies!
first:Wine, second:Beer
first:Wine, second:Beer
 */
