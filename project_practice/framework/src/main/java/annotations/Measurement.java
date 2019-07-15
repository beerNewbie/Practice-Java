package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Beer
 * @Date: 2019/7/15 15:18
 * @Description:
 * Retention[译：保留]
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Measurement {
    //一组实验调用多少次方法
    int iterations() ;
    //一共进行多少组实验
    int group() ;

}
