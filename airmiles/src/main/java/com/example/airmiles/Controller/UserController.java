package com.example.airmiles.Controller;

import com.example.airmiles.model.Post;
import com.example.airmiles.model.User;
import com.example.airmiles.service.PostService;
import com.example.airmiles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class UserController {

    @Autowired
    UserService userService;

    private static int counter=0;

    @GetMapping("/users")
    public List<User> getAllUsers(){

       innitilize();

        List<User> users= userService.getallUsers();

        return users;
    }

    public void innitilize(){
        if(counter==0) {
            counter++;
            User temp = new User("Dave", "pwd");
            userService.addUser(temp);
            temp = new User("Lee", "pwd");
            userService.addUser(temp);
        }
    }

}
