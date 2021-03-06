package com.revature.controllers;

import java.util.Optional;

import javax.inject.Inject;

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

import com.revature.entities.Utensil;
import com.revature.services.UtensilServices;
@RestController // All methods infer @ResponseBody
@RequestMapping("utensil")
public class UtensilController {
	@Autowired
private UtensilServices utensilService;
	
	/*
	@Inject
	public UtensilController(UtensilServices utensilService) {
		super();
		this.utensilService = utensilService;
	}*/

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

	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
