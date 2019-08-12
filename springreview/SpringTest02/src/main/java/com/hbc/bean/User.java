package com.hbc.bean;


/**
 * @Author: Beer
 * @Date: 2019/8/10 19:28
 * @Description:
 */

public class User {
    private String name;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String say() {
        return  "Hello world!!!";
    }
}
