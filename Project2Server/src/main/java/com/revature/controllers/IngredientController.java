package com.revature.controllers;

import java.util.List;
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

import com.revature.DTOs.SearchDTO;
import com.revature.entities.Ingredient;
import com.revature.services.IngredientServices;
@RestController // All methods infer @ResponseBody
@RequestMapping("ingredient")
public class IngredientController {
	@Autowired
	private IngredientServices ingredientService;

	/*
	@Inject
	public IngredientController(IngredientServices ingredientService) {
		super();
		this.ingredientService = ingredientService;
	}*/

	@GetMapping("/search/")
	public List<Ingredient> searchByName(@RequestBody SearchDTO search) {
		List<Ingredient> toRet = this.ingredientService.getByName(search.getItem());
		if(toRet == null)
		{
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		return toRet;			
			
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
		return this.ingredientService.create(ingredient);
	}
	
	@PutMapping("")
	public Ingredient updateIngredient(@RequestBody Ingredient ingredient) {
		return this.ingredientService.update(ingredient);
	}
	
	@DeleteMapping("/{id}")
	public Ingredient deleteIngredient(@PathVariable int id) {
		return this.ingredientService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
