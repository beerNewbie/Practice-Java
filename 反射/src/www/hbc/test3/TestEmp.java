package www.hbc.test3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Beer
 * @Date: 2019/3/31 22:49
 * @Description:反射与单级VO操作
 */

class Emp {
    private String ename;
    private String sex;
    private String job;
    private String skill;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", sex='" + sex + '\'' +
                ", job='" + job + '\'' +
                ", skill='" + skill + '\'' +
                '}';
    }
}

public class TestEmp {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {
        String str = "ename:张三|sex:male|job:SoftwareEngineer|skill:C、C++、Java";
        Emp emp = new Emp();
        String[] split = str.split("\\|");
        for (String attribute : split) {//attribute:属性
            setXxx(emp,attribute);
        }
        System.out.println(emp);
    }
    //设置属性
    public static void setXxx(Emp emp,String st) throws
            NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> classz = emp.getClass();
        String[] setments = st.split(":");
        String attribute = setments[0];
        String attributeMethodName =
                "set" + attribute.substring(0,1).toUpperCase() +
                        ((attribute.length() > 1) ? attribute.substring(1) : " ");
        Method method = classz.getDeclaredMethod(attributeMethodName,String.class);
        method.invoke(emp,setments[1]);
    }
}
/**
 * 结果：
 * Emp{ename='张三', sex='male', job='SoftwareEngineer', skill='C、C++、Java'}
 */
