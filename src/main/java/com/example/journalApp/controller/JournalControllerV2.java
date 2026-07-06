package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.sevice.JournalService;
import com.example.journalApp.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {

    @Autowired
    private JournalService journalService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = journalService.getAll();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public JournalEntry showById(@PathVariable Long id){

        return journalService.getById(id);
    }

    @PostMapping
    public boolean adddata(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
       journalService.saveData(myEntry);
        return true;

    }

    @PutMapping("/{id}")
    public JournalEntry updataData(@PathVariable Long id,@RequestBody JournalEntry myEntry){

        myEntry.setDate(LocalDateTime.now());
        return journalService.update(id,myEntry);
    }

    @DeleteMapping("/{id}")
    public boolean deletedata(@PathVariable Long id){
        journalService.deleteData(id);
        return true;
    }

}
