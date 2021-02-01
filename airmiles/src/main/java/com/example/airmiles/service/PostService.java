package com.example.airmiles.service;

import com.example.airmiles.model.City;
import com.example.airmiles.model.Post;
import com.example.airmiles.model.PostReply;
import com.example.airmiles.repository.PostReplyRepository;
import com.example.airmiles.repository.PostRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostReplyRepository postReplyRepository;

    public List<Post> getAllPosts(){

        List<Post> posts = postRepository.findAll();

        posts.forEach((post -> {
            List<PostReply> replies= postReplyRepository.findBypostID(post.getPostID());
            post.setPostReplies(replies);
            try {
                post.setCity(getCity(post.getCityID()));
            }catch(Exception ex){
                System.out.println(ex);
            }

        }));

        return posts;
    }

    public City getCity(String city) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&units=imperial&appid=9865dfdfbcb37f82e72515e8eb2d13e8";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        //Get Lat and Long from the root node
        JsonNode coord = root.path("coord");
        JsonNode lat = coord.path("lat");
        JsonNode lon = coord.path("lon");
        //Get tempurature from root node
        JsonNode weather = root.path("main");
        JsonNode temp = weather.path("temp");
        City postcity = new City(city,lat.toString(),lon.toString(),temp.toString());
        return postcity;
    }

    public Post addPost(Post post){
        post.setCreatedDate(LocalDate.now());
        return postRepository.save(post);
    }

    public PostReply addReply(PostReply replypost){
        return postReplyRepository.save(replypost);
    }

}
