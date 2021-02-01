package com.example.airmiles.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "postreply")
public class PostReply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postreplyid")
    private long postreplyID;

    @Column(name = "postid")
    private long postID;

    @Column(name = "postreplytext")
    private String postreplyText;

}
