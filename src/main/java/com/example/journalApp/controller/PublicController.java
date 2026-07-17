package com.example.journalApp.controller;

import com.example.journalApp.entity.User;
import com.example.journalApp.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveNewUser(user);
    }

    @PostMapping("/admin")
    public User createAdmin(@RequestBody User user){
        return userService.saveAdmin(user);
    }

}
