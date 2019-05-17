package com.revature.controllers;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Comment;
import com.services.services.CommentServices;

public class CommentController {
private CommentServices commentService;
	
	@Inject
	public CommentController(CommentServices commentService) {
		super();
		this.commentService = commentService;
	}

	@GetMapping("/{id}")
	public Comment getById(@PathVariable int id) {
		return Optional.ofNullable(this.commentService.getById(id))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Comment createComment(@RequestBody Comment comment) {
		return this.commentService.create(comment);
	}
	
	@PutMapping("")
	public Comment updateComment(@RequestBody Comment comment) {
		return this.commentService.update(comment);
	}
	
	@DeleteMapping("/{id}")
	public Comment deleteComment(@PathVariable int id) {
		return this.commentService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
