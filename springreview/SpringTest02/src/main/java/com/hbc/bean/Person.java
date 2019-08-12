package com.hbc.bean;


/**
 * @Author: Beer
 * @Date: 2019/8/9 19:21
 * @Description:
 */

public class Person {

    //
    private String name;

    public Person() {
    }

    public Person(String name0) {
        this.name = name0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String say(String msg) {
        return msg;
    }
}
