//数组与方法互操作
public class Day8 {
   public static void main(String[] args) {
         int[] data = init();//方法返回数组
         bigger(data);//方法修改数组
         printArray(data);//方法接收数组
   }
   public static int[] init() {
      return new int[] {1,2,3,4,5,6};
   }
   public static void bigger(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         arr[i] *= 5;
      }
   }
   public static void printArray(int[] temp) {
      for (int i = 0; i < temp.length; i++) {
         System.out.print(temp[i]+"、");
      }
   }
}

//数组排序
public class Day8 {
   public static void main(String[] args) {
      int[] intData =  new int[] {3,5,7,82,12,2,78};
      char[] charData = new char[] {'a','A','m','k','P'};
      java.util.Arrays.sort(intData);//java类库中数组排序操作：java.util.Arrays.sort(arrayName);
      java.util.Arrays.sort(charData);
      printArray(intData);
      printArray(charData);
   }
   public static void printArray(int[] temp) {
      for (int i=0; i<temp.length; i++) {
         System.out.print(temp[i]+"、");
      }
      System.out.println();
   }
   public static void printArray(char[] temp) {
      for (int i=0; i<temp.length; i++) {
         System.out.print(temp[i]+"、");
      }
   }
}

//数组拷贝
public class Day8 {
   public static void main(String[] args) {
      int[] dataA = new int[] {1,2,3,4,5,6,7,8,9};
      int[] dataB = new int[] {99,88,77,66,55};
      int[] dataC = new int[] {1,2,3,4,5};
      int[] result = java.util.Arrays.copyOf(dataC,10);//数组拷贝java.util.Arrays.copyOf(
                                                      //源数组名称，新数组长度);
      System.arraycopy(dataB,1,dataA,1,3);//数组部分拷贝System.arraycopy(源数组，源开始点，
                                          //目标数组，目标开始点，拷贝长度);
      printArray(dataA);
      printArray(result);
   }
   public static void printArray(int[] temp) {
      for (int i=0; i<temp.length; i++) {
         System.out.print(temp[i]+"、");
      }
      System.out.println();
   }
}

//数组统计
public class Day8 {
   public static void main(String[] args) {
      processData(init());//数组统计      
   }
   public static int[] init() {
      return new int[] {1,2,5,7,56,89,5,9};
   }
   public static void processData(int[] temp) {
      double[] result = new double[4];
      result[0] = temp[0];//sum
      result[1] = temp[0];//max
      result[2] = temp[0];//min
      result[3] = temp[0];//avg
      for (int i=0; i<temp.length; i++) {
         result[0] += temp[i];
         if (temp[i]>result[1]) {
            result[1] = temp[i];//逐一比较
         }
         if (temp[i]<result[2]) {
            result[2] = temp[i];
         }
      }
      result[3] = result[0]/temp.length;
      System.out.println("总和为："+result[0]);
      System.out.println("最大值为："+result[1]);
      System.out.println("最小值为："+result[2]);
      System.out.println("平均值为："+result[3]);
   }
}

 //对象数组
class Person {
   private String name;
   private int age;
   public Person(String name,int age) {
      this.name = name;
      this.age = age;
   }
   public void getInfo() {
      System.out.println("姓名："+this.name+"，年龄："+this.age);
   }
}
public class Day8 {
   public static void main(String[] args) {
      // Person[] per = new Person[3];
      // per[0] = new Person("张三",18);
      // per[1] = new Person("李四",19);
      // per[2] = new Person("王五",20);
      Person[] per = new Person[] {
         new Person("张三",18),
         new Person("李四",19),
         new Person("王五",20)
      } ;
      for (int i=0; i<per.length; i++) {
         per[i].getInfo();
      }
   }
}
