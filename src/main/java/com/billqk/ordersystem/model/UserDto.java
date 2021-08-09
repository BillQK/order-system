package com.billqk.ordersystem.model;

import java.net.URL;

public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private int mobile;

    public int getMobile() {
        return mobile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMobile(int mobile) {
    }
}
