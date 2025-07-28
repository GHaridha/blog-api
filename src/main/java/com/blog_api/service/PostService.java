package com.blog_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog_api.dao.PostDao;
import com.blog_api.exception.PostNotFoundException;
import com.blog_api.model.Post;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;
	
	public Post savePost(Post post) {
		return postDao.savePost(post);
	}
	
	public Post getPostById(int id) {
		return postDao.getPostById(id).orElseThrow(()-> new PostNotFoundException("Post is not found with given id "+id));
	}
	
	public List<Post> getAllPost(){
		return postDao.getAllPosts();
	}
	
	public String removePost(int id) {
		return postDao.removePost(id);
	}
}
