package com.blog.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entites.Post;
import com.blog.repository.PostRepo;
import com.blog.payLoads.*;

@Service
public class PostService {
	@Autowired
	private PostRepo postRepo;

	@Autowired
	private ModelMapper modelMapper;
	// save post

	public PostDto createPost(PostDto postDto) {
		Post post = this.modelMapper.map(postDto, Post.class);
		return this.modelMapper.map(this.postRepo.save(post), PostDto.class);
	}

	// Update

	public PostDto updatePost(PostDto postDto, int id) {
		Post savedPost = postRepo.findPostById(id);
		

		return null;
	}

	// delete

	// Get All post

	// Get Single post

	// Get all post by category

	// Get All post by User

	// search by keyword
}
