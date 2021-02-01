package com.example.airmiles.repository;

import com.example.airmiles.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User,Long> {

    User findByusername(String username);

    List<User> findAll();
}
