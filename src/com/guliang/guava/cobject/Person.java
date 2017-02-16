package com.guliang.guava.cobject;

/**
 * Created by HuangHailiang on 2017/2/14.
 */
public class Person {
    private int age;
    private String name;
    private String password;

    public Person(int age, String name, String password) {
        this.age = age;
        this.name = name;
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
