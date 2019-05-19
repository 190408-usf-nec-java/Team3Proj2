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

import com.revature.entities.Contain;
import com.revature.entities.Contain;
import com.services.services.ContainServices;
import com.services.services.ContainServices;

public class ContainController {
	
private ContainServices containService;
	
	@Inject
	public ContainController(ContainServices containService) {
		super();
		this.containService = containService;
	}

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
	
	@PutMapping("")
	public Contain updateContain(@RequestBody Contain contain) {
		return this.containService.update(contain);
	}
	
	@DeleteMapping("/{id}")
	public Contain deleteContain(@PathVariable int id) {
		return this.containService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
