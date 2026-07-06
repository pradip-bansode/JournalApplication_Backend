//package com.example.journalApp.controller;
//
//
//import com.example.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
////    private Map<Long, JournalEntry> journalEntrys = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> showData(){
//        return new ArrayList<>(journalEntrys.values());
//    }
//
//    @GetMapping("/{id}")
//    public JournalEntry showByid(@PathVariable Long id){
//        return journalEntrys.get(id);
//    }
//
//    @PostMapping
//    public String addStudata(@RequestBody JournalEntry myEntry){
//         journalEntrys.put(myEntry.getId(),myEntry);
//        return "add";
//    }
//
//    @PutMapping("/{id}")
//    public boolean updateData(@PathVariable Long id , @RequestBody JournalEntry myEntry){
//        journalEntrys.put(id, myEntry);
//        return true;
//    }
//
//    @DeleteMapping("/{id}")
//    public boolean deletedata(@PathVariable Long id){
//        journalEntrys.remove(id);
//        return true;
//    }
//
//
//
//}
