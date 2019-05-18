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

import com.revature.entities.User;
import com.services.services.UserServices;

public class UserController {

	private UserServices userService;
	
	@Inject
	public UserController(UserServices userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return Optional.ofNullable(this.userService.getById(id))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		return this.userService.create(user);
	}
	
	@PutMapping("")
	public User updateUser(@RequestBody User user) {
		return this.userService.update(user);
	}
	
	@DeleteMapping("/{id}")
	public User deleteUser(@PathVariable int id) {
		return this.userService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
}