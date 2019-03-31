package www.hbc.test3;

import java.lang.reflect.Field;

/**
 * @Author: Beer
 * @Date: 2019/3/31 21:00
 * @Description:将源对象中与目的对象相同属性，源对象的属性值copy赋值给目的对象
 */

class Teacher {
    private String name;
    private String skill;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", age=" + age +
                '}';
    }
}

class User {
    private String name;
    private int id;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

public class BeanCopy {
    /**
     *
     * @param sourse 源对象属性值
     * @param target 目标对象属性值
     */
    public static void copy(Object sourse,Object target) {
        if (sourse == null || target == null) {
            throw new IllegalArgumentException("Parameter must be not null");
        }
        //获取对象的Class对象
        Class<?> sourseClass = sourse.getClass();
        Class<?> targetClass = target.getClass();
        //获取属性
        Field[] sourseClassDeclaredFields = sourseClass.getDeclaredFields();
        Field[] targetClassDeclaredFields = targetClass.getDeclaredFields();
        //遍历找出属性名相同的属性名称
        for (Field s : sourseClassDeclaredFields) {
            for (Field t : targetClassDeclaredFields) {
                t.toString();//??
                if (s.getName().equals(t.getName())) {
                    //属性赋值
                    s.setAccessible(true);
                    t.setAccessible(true);
                    Object value = null;
                    try {
                        value = s.get(sourse);
                        t.set(target,value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setSkill("Java");
        teacher.setAge(30);
        User user = new User();
        user.setId(101);
        copy(teacher,user);
        System.out.println(teacher);
        System.out.println(user);
    }
}
/**
 * 结果:
 * Teacher{name='张三', skill='Java', age=30}
 * User{name='张三', id=101, age=30}
 */

