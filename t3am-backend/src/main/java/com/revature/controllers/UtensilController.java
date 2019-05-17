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

import com.revature.entities.Utensil;
import com.services.services.UtensilServices;

public class UtensilController {

private UtensilServices utensilService;
	
	@Inject
	public UtensilController(UtensilServices utensilService) {
		super();
		this.utensilService = utensilService;
	}

	@GetMapping("/{id}")
	public Utensil getById(@PathVariable int id) {
		return Optional.ofNullable(this.utensilService.getById(id))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Utensil createUtensil(@RequestBody Utensil utensil) {
		return this.utensilService.create(utensil);
	}
	
	@PutMapping("")
	public Utensil updateUtensil(@RequestBody Utensil utensil) {
		return this.utensilService.update(utensil);
	}
	
	@DeleteMapping("/{id}")
	public Utensil deleteUtensil(@PathVariable int id) {
		return this.utensilService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
}
