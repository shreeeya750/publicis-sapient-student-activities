package com.example.controller;

import com.example.model.service.UserServiceImpl;
import com.example.model.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/user")
public class MyRestApi {
    @Autowired
    private UserServiceImpl service;

//    Example #1: GET
//    @GetMapping
//    public User getUser() {
//        User user = new User();
//        user.setUserId(12345);
//        user.setName("Mica");
//        user.setDob(LocalDate.parse("2001-03-30"));
//        return user;
//    }

//    Example #2: POST
//    @PostMapping
//    public User store(@RequestBody User user) {
//        User createdUser = service.storeUser(user);
//        return createdUser;
//    }
//
//    @GetMapping
//    public List<User> fetchUsers() {
//        return service.getAllUsers();
//    }

//    Example #3: Request
    @PostMapping
    public ResponseEntity<Object> store(@RequestBody User user) {
        User createdUser = service.storeUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

//    @GetMapping
//    public ResponseEntity<Object> fetchUsers() {
//        List<User> users = service.getAllUsers();
//        return ResponseEntity.status(HttpStatus.OK).body(users);
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getMessage(@PathVariable("userId") int id){
        Map<String, String> map = new HashMap<String, String>();
        List<User> users = service.getAllUsers();
        for (User user:users) {
            if (user.getUserId() == id) {
                map.put("message", "Valid id: " + id);
                return ResponseEntity.status(HttpStatus.OK).body(map);
            }
        }
        map.put("error", ":sorry user with an id " + id + " not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }


    @Bean
    public UserServiceImpl getUserServiceImpl() {
        return new UserServiceImpl();
    }
}
