package com.example.journalApp.sevice;

import com.example.journalApp.entity.JournalEntry;
import com.example.journalApp.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    @Autowired
    private JournalRepository repo;

    public void saveData(JournalEntry journalEntry) {
        repo.save(journalEntry);
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

        return repo.save(myEntry);
    }


}