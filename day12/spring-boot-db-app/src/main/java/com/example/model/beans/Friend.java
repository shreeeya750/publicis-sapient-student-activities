package com.example.model.beans;

import javax.persistence.*;

@Entity
public class Friend {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getProfileIdRef() {
        return profileIdRef;
    }

    public void setProfileIdRef(int profileIdRef) {
        this.profileIdRef = profileIdRef;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long phone;

    // foreign key
    @Column(name = "profileidref")
    private int profileIdRef;
}
