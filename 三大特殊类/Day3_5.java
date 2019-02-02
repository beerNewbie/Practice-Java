public class Test {
    public static void main(String[] args) {
        Object obj = new int[]{1,2,3,4,5,6,7,8};
        int[] data = (int[]) obj;
        for (int i : data) {
            System.out.print(i+"、");
        }
        /**
         * 注意：for (int i : data)意思是遍历data数组，每次遍历的对象用i去接收；
         *   相当于int i=0；
         *         for (int j=0; j<data.length; j++) {
         *         i = data[j];
         *         }
         */
    }
}
