package www.hbc.test2;

import java.lang.reflect.Field;

/**
 * @Author: Beer
 * @Date: 2019/3/30 17:38
 * @Description:
 */
public class PropertyUtil {
    //per.setXxx(val);
    public static void setProperty(Object obj,String propertyName,Object value) throws NoSuchFieldException, IllegalAccessException {
        Class<?> aClass = obj.getClass();
        Field field = aClass.getDeclaredField(propertyName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
