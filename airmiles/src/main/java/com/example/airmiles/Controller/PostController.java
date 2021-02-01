package com.example.airmiles.Controller;


import com.example.airmiles.model.Post;
import com.example.airmiles.model.PostReply;
import com.example.airmiles.service.PostService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public List<Post> getAllPosts() throws Exception{

        List<Post> posts= postService.getAllPosts();

        return posts;
    }

    @PostMapping("/posts")
    public ResponseEntity postController(@RequestBody Post post) throws Exception {

        postService.addPost(post);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/posts/reply")
    public ResponseEntity postreplyController(@RequestBody PostReply postreply) throws Exception {

        postService.addReply(postreply);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
