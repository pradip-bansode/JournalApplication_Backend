package com.example.journalApp.controller;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.sevice.JournalService;
import com.example.journalApp.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalControllerV2 {

    @Autowired
    private JournalService journalService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllJournalEntriesOfUser(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName= authentication.getName();
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName= authentication.getName();
       User user = userService.findByUserName(userName);
      List<JournalEntry> collect =  user.getJournalEntries().stream().filter(x -> x.getId().equals(id)).collect(Collectors.toList());
      if(!collect.isEmpty()){
          Optional<JournalEntry> journalEntry = journalService.getById(id);
          if(journalEntry.isPresent()){
              return new ResponseEntity<>(journalEntry.get() , HttpStatus.OK);
          }
      }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> adddata(@RequestBody JournalEntry myEntry ){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName= authentication.getName();
        try {
            journalService.saveData(myEntry , userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntry>  updataData(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String userName= authentication.getName();
JournalEntry updated = journalService.update(id, myEntry );
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
