package com.example.airmiles.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {



    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private long userID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username.equals(user.username);
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

