package com.hbc.bean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @Author: Beer
 * @Date: 2019/8/9 19:45
 * @Description:
 */


public class UserInfoTest {

    /**
     * Spring API (Application Interface)
     *
     */
    private ApplicationContext applicationContext = null;
    @Before
    public void testInitial() {
        //读取类路径下的applicationContext.xml文件
        applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-test.xml");

    }

    @Test
    public void testMethod() {
        Person person = (Person) applicationContext.getBean("person");
        System.out.println("name = " + person.getName());
        System.out.println(person.say("Hello Spring"));
    }

    @Test
    public void testMethod2() {
        UserInfo userInfo = (UserInfo) applicationContext.getBean("userInfo");
        System.out.println("personName "+userInfo.getPerson().getName());
    }

}