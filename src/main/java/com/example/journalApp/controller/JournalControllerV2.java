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
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{userName}/{id}")
    public JournalEntry showById(@PathVariable Long id, @PathVariable String userName){

        return journalService.getById(id);
    }

    @PostMapping("/{userName}")
    public ResponseEntity<JournalEntry> adddata(@RequestBody JournalEntry myEntry , @PathVariable String userName){
        try {
            journalService.saveData(myEntry , userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PutMapping("/{userName}/{id}")
    public ResponseEntity<JournalEntry>  updataData(@PathVariable Long id,@RequestBody JournalEntry myEntry, @PathVariable String userName){

JournalEntry updated = journalService.update(id, myEntry);
   if(updated != null){
       return new ResponseEntity<>(updated, HttpStatus.OK);
   }
   return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }

    @DeleteMapping("/{userName}/{id}")
    public boolean deletedata(@PathVariable String userName,@PathVariable Long id){
        journalService.deleteData(id);
        return true;
    }

}
