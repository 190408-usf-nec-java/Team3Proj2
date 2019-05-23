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
import com.revature.entities.Recipe;
import com.revature.services.RecipeServices;
@RestController // All methods infer @ResponseBody
@RequestMapping("recipe")
public class RecipeController {
	@Autowired
private RecipeServices recipeService;
	
	/*
	@Inject
	public RecipeController(RecipeServices recipeService) {
		super();
		this.recipeService = recipeService;
	}*/

	@GetMapping("/{id}")
	public Recipe getById(@PathVariable int id) {
		return Optional.ofNullable(this.recipeService.getById(id))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/search/")
	public List<Recipe> searchByName(@RequestBody SearchDTO search) {
		List<Recipe> toRet = this.recipeService.getByName(search.getRecipe());
		if(toRet == null)
		{
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		return toRet;			
			
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		return this.recipeService.create(recipe);
	}
	

	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}
}
