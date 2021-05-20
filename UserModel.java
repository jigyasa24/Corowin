package com.example.helpus;

import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("name")
    private String name;

    @SerializedName("contact")
    private String contact;

    @SerializedName("age")
    private String age;

    @SerializedName("bg")
    private String bg;

    @SerializedName("address")
    private String address;

    @SerializedName("password")
    private String password;

    public UserModel(String name, String contact, String age, String bg, String address, String password) {
        this.name = name;
        this.contact = contact;
        this.age = age;
        this.bg = bg;
        this.address = address;
        this.password = password;
    }

    public UserModel() {
    }

    public String getAge() {
        return age;
    }

    public String getBg() {
        return bg;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getContact() { return contact; }

    public String getPassword() { return password; }
}
