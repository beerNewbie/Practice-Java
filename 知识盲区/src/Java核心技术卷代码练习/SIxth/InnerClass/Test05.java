package Java核心技术卷代码练习.SIxth.InnerClass;


/**
 * @Author: Beer
 * @Date: 2019/8/6 22:45
 * @Description: 测试静态内部类
 */

public class Test05 {
    public static void main(String[] args) {
        /*double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }
        ArrayAlg arrayAlg = new ArrayAlg();
        ArrayAlg.Pair p  = arrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());*/
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        System.out.println(min);//Infinity
        System.out.println(max);//-Infinity
        System.out.println(0.0/0);//NaN
        System.out.println(0/0.0);//NaN
    }
}

class ArrayAlg {
    /**
     * 静态内部类
     */
    public static class Pair {
        private double first;
        private double second;

        public Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    public  Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) min = v;
            if (max < v) max = v;
        }
        return new Pair(min, max);
    }
}