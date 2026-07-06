package com.example.journalApp.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user_Id")
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)

    private String userName;


    private String password;

    @OneToMany(mappedBy = "user")
    private List<JournalEntry>journalEntries= new ArrayList<>();


}
