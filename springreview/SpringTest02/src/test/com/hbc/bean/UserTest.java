package com.hbc.bean;

import com.hbc.bean3.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


/**
 * @Author: Beer
 * @Date: 2019/8/10 19:35
 * @Description:
 */


public class UserTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void testInitial() {
        context = new AnnotationConfigApplicationContext(SpringConfig.class);

    }

    @Test
    public void testMethod() {
        User user = (User) context.getBean("user");
        System.out.println(user.say());//Hello world!!!
    }
}