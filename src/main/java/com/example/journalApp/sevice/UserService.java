package com.example.journalApp.sevice;

import com.example.journalApp.entity.User;
import com.example.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    private static final PasswordEncoder passwordencoder = new BCryptPasswordEncoder();

    public User saveUser(User user){
      user.setPassword(passwordencoder.encode(user.getPassword()));
      user.setRole(Arrays.asList("user"));
        return repo.save(user);
    }

    public List<User> showUser(){
        return repo.findAll();
    }

    public boolean deletUser(Long id){
        repo.deleteById(id);
        return true;
    }

    public User findByUserName(String userName){
        return repo.findByUserName(userName);
    }
}
