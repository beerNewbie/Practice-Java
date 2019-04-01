package www.hbc.test4;

/**
 * @Author: Beer
 * @Date: 2019/4/1 0:48
 * @Description:自定义类加载器
 */

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
//观察默认类加载器
class Member01 {
    @Override
    public String toString() {
        return "Member01";
    }
}
public class TestDemo02 {
    public static void main(String[] args) throws Exception{
        System.out.println(Class.forName("Member01").getClassLoader().loadClass("Member01").newInstance());
    }
}
*/
class MyClassLoader extends ClassLoader {
    /**
     * 实现一个自定义的类加载器，传入类名称，通过指定路径加载
     * @param className
     * @return返回的Class对象
     * @throws Exception
     */
    public Class<?> loadData(String className) throws Exception {
        byte[] classData = this.loadClassData();
        return super.defineClass(className,classData,0,classData.length);
    }

    private byte[] loadClassData() throws Exception {
        FileInputStream input = new FileInputStream("C:\\Users\\DELL\\Desktop\\Java\\SingletonTest.class");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data = new byte[20];
        int temp = 0;
        while((temp =  input.read(data)) != -1) {
            bos.write(data,0,temp);
        }
        byte[] result = bos.toByteArray();
        input.close();
        bos.close();
        return result;
    }
}
public class TestDemo02 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = new MyClassLoader().
                loadData("SingletonTest");
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
        System.out.println(cls.newInstance());
    }
}
/**
 * 结果：
 * www.hbc.test4.MyClassLoader@677327b6
 * sun.misc.Launcher$AppClassLoader@18b4aac2
 * sun.misc.Launcher$ExtClassLoader@7f31245a
 * SingletonTest@6d6f6e28
 */
