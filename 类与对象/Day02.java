class Person {
    private static String country ;
    private String name;
    private int age;
   public Person(String name, int age) {
       this.name = name;
       this.age = age;
   }
   public static void setCountry(String c) {
       country = c;
   }
    public void  getPersonInfo() {
        System.out.println("姓名："+this.name+",年龄："+this.age+",国籍："+this.country);
    }
}
public class Day02 {
    public static void main(String[] args) {
        Person.setCountry("中华人民共和国");
        Person per1 = new Person("张三", 20);
        Person per2 = new Person("李四",19);
        per1.getPersonInfo();
        per2.getPersonInfo();
    }
}
