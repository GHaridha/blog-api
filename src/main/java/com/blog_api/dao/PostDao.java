package com.blog_api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog_api.exception.PostNotFoundException;
import com.blog_api.model.Post;
import com.blog_api.repository.PostRepository;

@Repository
public class PostDao {

	@Autowired
	private PostRepository postRepository;
	
	public Post savePost(Post post) {
		postRepository.save(post);
		return post;
	}
	
	public Optional<Post> getPostById(int id) {
		return postRepository.findById(id);
	}
	
	public List<Post> getAllPosts(){
		List<Post> allPosts = postRepository.findAll();
		return allPosts;
	}
	
	public String removePost(int id) {
		postRepository.deleteById(id);
		return "Post has been removed from the blog";
	}
}
