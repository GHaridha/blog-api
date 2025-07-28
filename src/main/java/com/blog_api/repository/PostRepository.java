package com.blog_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog_api.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
