package com.example.model.beans;

import java.time.LocalDate;
public class User {
    private int userId;
    private String name;
    private LocalDate dob;

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}

