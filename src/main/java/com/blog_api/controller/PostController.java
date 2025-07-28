package com.blog_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog_api.model.Post;
import com.blog_api.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@PostMapping
	public Post savePost(@RequestBody Post post) {
		return postService.savePost(post);
	}
	
	@PutMapping
	public Post updatePost(@RequestBody Post post) {
		return postService.savePost(post);
	}
	
	@GetMapping("/{id}")
	public Post findPostById(@PathVariable int id) {
		return postService.getPostById(id);
	}
	
	@GetMapping
	public List<Post> getAllPosts() {
		return postService.getAllPost();
	}
	
	
	@DeleteMapping("/{id}")
	public String deletePostById(@PathVariable int id) {
		return postService.removePost(id);
	}
}
