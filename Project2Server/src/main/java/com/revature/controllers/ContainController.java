package com.revature.controllers;

import java.util.Optional;

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

import com.revature.entities.Contain;
import com.revature.services.ContainServices;
@RestController // All methods infer @ResponseBody
@RequestMapping("contain")
public class ContainController {
	@Autowired
	private ContainServices containService;

	
	/*@Inject
	public ContainController(ContainServices containService) {
		super();
		this.containService = containService;
	}*/

	@GetMapping("/{id}")
	public Contain getById(@PathVariable int id) {
		return Optional.ofNullable(this.containService.getById(id))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Contain createContain(@RequestBody Contain contain) {
		return this.containService.create(contain);
	}
	
	
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
