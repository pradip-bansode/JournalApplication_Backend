package com.example.journalApp.sevice;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.entity.User;
import com.example.journalApp.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository repo;

    @Autowired
    private UserService userService;

    public void saveData(JournalEntry journalEntry, String userName)
    {
        User user = userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        journalEntry.setUser(user);
       JournalEntry saved= repo.save(journalEntry);

       user.getJournalEntries().add(saved);
       userService.saveUser(user);
    }

    public List<JournalEntry> getAll() {
        return repo.findAll();
    }

    public JournalEntry getById(Long id) {
        return repo.findById(id).orElse(null);
    }


    public void deleteData(Long id) {
        repo.deleteById(id);
    }

    public JournalEntry update(Long id, JournalEntry myEntry) {
    JournalEntry old = repo.findById(id).orElse(null);
    old.setTitle(myEntry.getTitle());
    old.setContent(myEntry.getContent());
        return repo.save(old);
    }


}