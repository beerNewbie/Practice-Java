package com.hbc.bean2;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


/**
 * @Author: Beer
 * @Date: 2019/8/9 21:01
 * @Description:
 */


public class Bean1Test {
    private ApplicationContext applicationContext;

    @Before
    public void testInitial() {
        applicationContext =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext-bean.xml"});
    }

    @Test
    public void testMethod() {
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        System.out.println("strValue = "+bean1.getStrValue());
        System.out.println("intValue = "+bean1.getIntValue());
        System.out.println("arrayValue = "+bean1.getArrayValue());
        System.out.println("setValue = " +bean1.getSetValue());
        System.out.println("mapValue = "+bean1.getMapValue());
        System.out.println("listValue = "+bean1.getListValue());
    }

}