package com.revature.controllers;

import java.util.Optional;

import javax.xml.ws.http.HTTPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.DTOs.LoginDTO;
import com.revature.DTOs.TokenDTO;
import com.revature.DTOs.UserDTO;
import com.revature.entities.Token;
import com.revature.entities.User;
import com.revature.services.UserServices;
@RestController // All methods infer @ResponseBody
@RequestMapping("users")
public class UserController {
	@Autowired
private UserServices userService;
	
	/*
	@Inject
	public UserController(UserServices userService) {
		super();
		this.userService = userService;
	}*/

	@GetMapping("/{id}")
	public User getById(@PathVariable int id) {
		return Optional.ofNullable(this.userService.getById(id))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/login/")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public TokenDTO loginUser(@RequestBody LoginDTO credentials) {
		System.out.println("logging in");
		Token ret = this.userService.login(credentials.getUsername(),credentials.getPassword());
		
		if (ret == null)
		{
			throw new HTTPException(401);
		}
		TokenDTO dto = new TokenDTO(ret.getId(), ret.getUser().getId(), ret.getExpiration());
		System.out.println("token created" + dto);
		return dto;
		
	}
	
	@PostMapping("/signup/")
	@ResponseStatus(HttpStatus.CREATED)
	public void signUpUser(@RequestBody UserDTO user) {
		this.userService.signUp(user);
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
