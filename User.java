package com.example.helpus.model;

import java.io.Serializable;

public final class User implements Serializable {
    private String name;
    private String contact;
    private String age;
    private String bg;
    private String address;
    private String password;

    public User() {
    }

    public User(String name, String contact, String age, String bg, String address, String password) {
        this.name = name;
        this.contact = contact;
        this.age = age;
        this.bg = bg;
        this.address = address;
        this.password = password;
    }

    public User(String contact, String password) {
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}