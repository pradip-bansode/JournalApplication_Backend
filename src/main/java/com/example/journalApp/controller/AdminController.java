//package com.example.journalApp.controller;
//
//import com.example.journalApp.entity.User;
//import com.example.journalApp.sevice.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/all")
//    public ResponseEntity<?> getAllUser(){
//        List<User>all = userService.showUser();
//        if(all != null && !all.isEmpty()){
//            return new ResponseEntity<>(all , HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//}
