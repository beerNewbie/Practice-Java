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
