package com.example.airmiles;

import com.example.airmiles.model.User;
import com.example.airmiles.repository.UserRepository;
import com.example.airmiles.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirmilesApplication {


	public static void main(String[] args) {
		SpringApplication.run(AirmilesApplication.class, args);

	}



}
