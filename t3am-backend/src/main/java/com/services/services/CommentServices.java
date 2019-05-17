package com.services.services;

import javax.inject.Inject;

import com.revature.entities.Comment;
import com.revature.entities.Comment;
import com.revature.repositories.CommentRepository;

public class CommentServices {
	

	CommentRepository commentRepository;

	@Inject
	public CommentServices(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}

	public Comment getById(int id) {
		return this.commentRepository.getById(id);
	}

	public Comment create(Comment comment) {
		return this.commentRepository.create(comment);
	}

	public Comment update(Comment comment) {
		return this.commentRepository.update(comment);
	}

	public Comment deleteById(int id) {
		return this.commentRepository.deleteById(id);
	}


}
