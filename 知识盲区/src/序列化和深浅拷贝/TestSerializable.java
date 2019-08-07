package 序列化和深浅拷贝;


import java.io.*;

/**
 * @Author: Beer
 * @Date: 2019/8/7 11:14
 * @Description:
 */

class Person implements Serializable {
    private String name;
    private transient Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestSerializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
       //Person person = new Person("C++",20);
        File file = new File("C:\\Users\\DELL\\Desktop\\Test.txt");
        //序列化
        /*OutputStream out = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        //反序列化：
        InputStream in = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Person per = (Person) objectInputStream.readObject();
        System.out.println(per);//Person{name='C++', age=20}
        */

        Person person = new Person("C++",20);
        File file = new File("C:\\Users\\DELL\\Desktop\\Test.txt");
        //序列化
        OutputStream out = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        //反序列化：
        InputStream in = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Person per = (Person) objectInputStream.readObject();
        System.out.println(per);//Person{name='C++', age=null}
        objectInputStream.close();
    }
}
