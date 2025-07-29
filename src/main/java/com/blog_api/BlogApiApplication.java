package com.blog_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	    info = @Info(
	        title = "Blog API",
	        version = "1.0",
	        description = "Backend API for blog post management"
	    )
	)
@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

}
