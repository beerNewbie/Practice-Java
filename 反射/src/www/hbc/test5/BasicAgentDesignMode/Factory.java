package www.hbc.test5.BasicAgentDesignMode;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author: Beer
 * @Date: 2019/4/1 23:47
 * @Description:
 */
class Factory {
    private Factory() {}
    public static <T> T getInstance(String className) {
        T t = null;
        try {
            t = (T)Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
    /**
    public static <T> T getInstance(String className,Object obj) throws ClassNotFoundException {
        T t = null;
        try {
            Constructor<?> cons =
            Class.forName(className).getConstructor(obj.getClass().getInterfaces()[0]);
            t = (T) cons.newInstance(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
    */
    //优化后：
    public static <T> T getInstance(String proxyClassName, String realClassName) {
        T t = null;
        try {
            T realObj = getInstance(realClassName);
            Constructor<?> cons =
                    Class.forName(proxyClassName).getConstructor(realObj.getClass().getInterfaces()[0]);
            t = (T) cons.newInstance(realObj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }
}
