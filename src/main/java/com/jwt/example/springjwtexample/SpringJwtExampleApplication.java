package com.jwt.example.springjwtexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringJwtExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtExampleApplication.class, args);
	}

}
