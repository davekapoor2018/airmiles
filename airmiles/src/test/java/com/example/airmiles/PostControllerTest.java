package com.example.airmiles;

import com.example.airmiles.model.Post;
import com.example.airmiles.model.PostReply;
import com.example.airmiles.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    PostService postService;

    Post post;

    PostReply postreply;

    ObjectMapper Obj;

    @Before
    public void init() {
        Post postModel = new Post();
        postreply = new PostReply();
        Obj = new ObjectMapper();
    }

    @Test
    public void testGetPosts() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/posts").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


    @Test
    public void testCreatePost() throws Exception {
        Post temp= new Post("TestUser","Salisbury", null,"Post text is here!");
        String requestJson = Obj.writeValueAsString(temp);
        mvc.perform(MockMvcRequestBuilders.post("/posts").content(requestJson).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreatePostIncorrectRequestBody() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/posts").content("posts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError());
    }



}
