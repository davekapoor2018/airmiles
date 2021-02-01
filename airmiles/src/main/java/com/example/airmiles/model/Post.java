package com.example.airmiles.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postid")
    private long postID;

    @Column(name = "userid")
    private String userID;

    @Column(name="cityid")
    private String cityID;

    @Column(name = "createddate")
    private LocalDate createdDate;

    @Column(name = "posttext")
    private String postText;

    @OneToMany
    @JoinColumn(name = "postid")
    private List<PostReply> postReplies;

    @Transient
    private City city;


    public Post(String userID, String cityID, LocalDate createdDate,String postText) {
        this.userID = userID;
        this.cityID = cityID;
        this.createdDate = createdDate;
        this.postText=postText;
    }

}
