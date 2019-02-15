package pers.hbc.arrays;

public class Test01 {
    public static void main(String[] args) {
        User[] arr = new User[3];
        arr[0] = new User(211,"zhang1");
        arr[1] = new User(212,"zhang2");
        arr[2] = new User(213,"zhang3");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].getName());
        }
    }

}
class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}