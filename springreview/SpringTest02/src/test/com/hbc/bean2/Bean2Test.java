package com.hbc.bean2;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


/**
 * @Author: Beer
 * @Date: 2019/8/10 17:53
 * @Description:
 */


public class Bean2Test {

    private ApplicationContext applicationContext;

    @Before
    public void testInitial() {
        applicationContext =
                new ClassPathXmlApplicationContext(new String[]{"applicationContext-bean.xml","applicationContext-bean2.xml"});
    }

    @Test
    public void testMethod() {
        /*Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
        System.out.println("=============bean3=============");
        System.out.println(bean2.getBean3().getId());
        System.out.println(bean2.getBean3().getUsername());
        System.out.println(bean2.getBean3().getPassword());
        System.out.println("=============bean4=============");
        System.out.println(bean2.getBean4().getId());
        System.out.println(bean2.getBean4().getUsername());
        System.out.println("=============bean5=============");
        System.out.println(bean2.getBean5().getAge());*/

        //测试Bean5是单例还是多例(默认是单例的，如果想改的话：scope="...")
        Bean5 bean5 = (Bean5) applicationContext.getBean("bean5");
        Bean5 bean51 = (Bean5) applicationContext.getBean("bean5");

        if (bean5==bean51) {
            System.out.println("Singleton");//Singleton
        }else {
            System.out.println("Multipart");
        }


    }
}