package com.hbc.bean3;


import com.hbc.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Beer
 * @Date: 2019/8/10 19:22
 * @Description:
 */

//加上后就是配置类，相当于applicationContex.xml
@Configuration
@ComponentScan(basePackages = "com.hbc")
public class SpringConfig {

    /**
     * 相当于applicationContext.xml中的：
     *      <bean id="user" class="com.hbc.bean.User"/>
     * @return
     */
    @Bean(name = "user")
    public User user() {
        User user = new User();
        return user;
    }
}
