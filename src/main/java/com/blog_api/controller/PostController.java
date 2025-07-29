package com.blog_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Posts", description = "Operations on blog posts")
@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Operation(
		    summary = "Create a new blog post",
		    description = "Adds a new blog post to the system and returns the created post."
		)
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "201", description = "Post created successfully"),
		    @ApiResponse(responseCode = "400", description = "Invalid input data")
		})
	@PostMapping
	public ResponseEntity<Post> savePost( @io.swagger.v3.oas.annotations.parameters.RequestBody(
	        description = "Post object to be created",
	        required = true
	    )
	    @RequestBody Post post) {
		Post savedPost= postService.savePost(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPost); 
	}
	
	
	@Operation(
		    summary = "Update an existing blog post",
		    description = "Modifies the details of an existing post given its ID"
		)
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Post updated successfully"),
		    @ApiResponse(responseCode = "404", description = "Post not found"),
		    @ApiResponse(responseCode = "400", description = "Invalid input data")
		})
	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost( @Parameter(description = "ID of the post to update", required = true) @PathVariable int id,
			@io.swagger.v3.oas.annotations.parameters.RequestBody(
			        description = "Post object to be updated",
			        required = true
			    )
			    @RequestBody Post post) {
		post.setId(id); 
		Post updatedPost= postService.savePost(post);
		return ResponseEntity.status(HttpStatus.OK).body(updatedPost); 
	}
	
	
	
	@Operation(
		    summary = "Get blog post by ID",
		    description = "Returns a blog post when given its ID"
		)
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "Post found"),
		    @ApiResponse(responseCode = "404", description = "Post not found")
		})
	@GetMapping("/{id}")
	public ResponseEntity<Post> findPostById( @Parameter(description = "ID of the post to fetch", required = true) @PathVariable int id) {
		Post post= postService.getPostById(id);
		return ResponseEntity.ok(post);
	}
	
	@Operation(summary = "Get all posts", description = "Returns list of all blog posts")
	@GetMapping
	public List<Post> getAllPosts() {
		return postService.getAllPost();
	}
	
	
	
	@Operation(
		    summary = "Delete a blog post",
		    description = "Removes a blog post from the system by its ID"
		)
	@ApiResponses(value = {
		    @ApiResponse(responseCode = "204", description = "Post deleted successfully"),
		    @ApiResponse(responseCode = "404", description = "Post not found")
		})
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePostById(@Parameter(description = "ID of the post to delete", required = true) @PathVariable int id) {
		 postService.removePost(id);
		 return ResponseEntity.noContent().build();
	}
}
