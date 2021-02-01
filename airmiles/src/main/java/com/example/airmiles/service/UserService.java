package com.example.airmiles.service;

import com.example.airmiles.model.User;
import com.example.airmiles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getallUsers(){
        return userRepository.findAll();
    }

    User getUser(String username){
        return userRepository.findByusername(username);
    }


}
