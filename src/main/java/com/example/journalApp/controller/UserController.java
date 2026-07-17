package com.example.journalApp.controller;

import com.example.journalApp.entity.User;
import com.example.journalApp.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping
//   public User createUser(@RequestBody User user){
//        return userService.saveNewUser(user);
//    }



//    @DeleteMapping
//    public boolean delteUserById(){
//        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
//        userService.deletUser(authentication.getName());
//        return true;
//    }

    @PutMapping
    public ResponseEntity<User> updataUser(@RequestBody User user ){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName= authentication.getName();
        User userIndb = userService.findByUserName(userName);
            userIndb.setUserName(user.getUserName());
            userIndb.setPassword(user.getPassword());
            userService.saveNewUser(userIndb);
        return new ResponseEntity<>(userIndb , HttpStatus.OK);
    }

}
