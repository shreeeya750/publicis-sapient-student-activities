package com.example.model.service;

import com.example.model.beans.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl {
    private static List<User> usersList = new ArrayList<User>();

    public User storeUser(User user) {
        int counter = usersList.size();
        user.setUserId(++counter);
        usersList.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return usersList;
    }
}
