package com.example.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health_check {


    @GetMapping("helth-check")
    public String Show(){
        return  "ok";
    }
}
