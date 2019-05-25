package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.DTOs.CommentDTO;
import com.revature.entities.Comment;
import com.revature.services.CommentServices;
import com.revature.services.RecipeServices;
import com.revature.services.UserServices;
@RestController // All methods infer @ResponseBody
@RequestMapping("comment")
public class CommentController {
	@Autowired
	private CommentServices commentService;
	private UserServices userService;
	private RecipeServices recipeService;

	/*@Inject
	public CommentController(CommentServices commentService) {
		super();
		this.commentService = commentService;
	}*/

	@GetMapping("")
	public Comment getById(@PathVariable int id) {
		return Optional.ofNullable(this.commentService.getById(id))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/post/")
	@ResponseStatus(HttpStatus.CREATED)
	public Comment createComment(@RequestBody CommentDTO toAdd) {
		return this.commentService.create(new Comment(toAdd.getDigest(), userService.getById(toAdd.getUser()), recipeService.getById(toAdd.getRecipe())));
	}
	

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
