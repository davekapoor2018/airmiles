package com.example.airmiles.repository;

import com.example.airmiles.model.Post;
import com.example.airmiles.model.PostReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostReplyRepository extends JpaRepository<PostReply,Long> {

    List<PostReply> findBypostID(long postID);
}
