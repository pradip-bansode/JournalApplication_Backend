package com.example.journalApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

//@Setter
//@Getter
@Entity
@Table(name = "journal_entry")
@Data
public class JournalEntry {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String title;

    private String content;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public JournalEntry() {
    }

    public JournalEntry(Long id, String title, String content, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date=date;
    }


}
