package www.hbc.test4;


/**
 * @Author: Beer
 * @Date: 2019/4/1 0:21
 * @Description:观察ClassLoad的存在
 */

/**
 * Bootstrap(启动类加载器)：这个类加载器使用C++实现，是虚拟机自身的一部分；其他的类加载器都由Java语言实
 * 现，独立于JVM外部并且都继承于java.lang.ClassLoader.BootStrap类加载器负责将存放于<Java_HOME>\lib目录
 * 中(或者被-Xbootclasspath参数指定路径中)能被虚拟机识别的(仅按照文件名识别，如rt.jar，名字不符合的类库即
 * 使放在lib目录中也不会被加载)类库加载到JVM内存中。启动类加载器无法被Java程序直接引用。
 *
 * ExtClassLoader(扩展类加载器)：它负责加载<Java_HOME>\lib\ext目录中，或者被java.ext.dirs系统变量指定的路
 * 径中的类库。开发者可以直接使用扩展类加载器。
 *
 * AppClassLoader(应用程序类加载器):负责加载用户类路径(ClassPath)上指定的类库，如果应用程序中没有自定义
 * 自己的类加载器，则此加载器就是程序中默认的类加载器。
 */
class Member {}
public class TestDemo01 {
    public static void main(String[] args) {
        Class<?> classz = Member.class;
        System.out.println(classz.getClassLoader());
        System.out.println(classz.getClassLoader().getParent());
        System.out.println(classz.getClassLoader().getParent().getParent());
    }
}
/**
 * 结果：
 * sun.misc.Launcher$AppClassLoader@18b4aac2
 * sun.misc.Launcher$ExtClassLoader@1540e19d
 * null
 */
