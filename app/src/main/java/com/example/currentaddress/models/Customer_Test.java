package com.example.currentaddress.models;

import java.io.Serializable;

public class Customer_Test implements Serializable {

    private String name;
    private String email;
    private long phone;
    private int pin;

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }

    public int getPin() {
        return pin;
    }

    public void setName(String name) {
        this.name = name;
    }
    public long setPhone(long phone) {
        this.phone = phone;
        return phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int setPin(int pin) {
        this.pin = pin;
        return pin;
    }
}
