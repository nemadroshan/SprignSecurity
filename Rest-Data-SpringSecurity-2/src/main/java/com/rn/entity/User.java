package com.rn.entity;

public class User {

    private String name;
    private int age;
    private String addrs;

    public User() {
        System.out.println("User.User");
    }

    public User(String name, int age, String addrs) {
        this.name = name;
        this.age = age;
        this.addrs = addrs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addrs='" + addrs + '\'' +
                '}';
    }
}
