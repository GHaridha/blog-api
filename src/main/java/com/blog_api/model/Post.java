package com.blog_api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Model representing a blog post")
@Entity
public class Post {

	@Schema(description = "ID of the post", example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Schema(description = "Title of the post", example = "My first post")
	@NotBlank
	private String title;
	
	@Schema(description = "Content of the post", example = "This is a test blog.")
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
