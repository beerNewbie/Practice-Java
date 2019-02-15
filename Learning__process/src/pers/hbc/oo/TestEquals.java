package pers.hbc.oo;

public class TestEquals {
    public static void main(String[] args) {
        User u1 = new User(212,"zhang","123");
        User u2 = new User(212,"Zhang","123");
        System.out.println(u1==u2);
        System.out.println(u1.equals(u2));
    }
}
class User {
    int id;
    String name;
    String pwd;

    public User(int id,String name,String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (getClass()!=obj.getClass())
            return false;
        User other = (User)obj;
        if (id!=other.id)
            return false;
        return true;
    }
}
