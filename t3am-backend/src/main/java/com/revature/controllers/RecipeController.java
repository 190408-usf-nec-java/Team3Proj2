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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Recipe;
import com.services.services.RecipeServices;
@RestController // All methods infer @ResponseBody
@RequestMapping("recipe")
public class RecipeController {
private RecipeServices recipeService;
	
	@Inject
	public RecipeController(RecipeServices recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@GetMapping("/{id}")
	public Recipe getById(@PathVariable int id) {
		return Optional.ofNullable(this.recipeService.getById(id))
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		return this.recipeService.create(recipe);
	}
	
	@PutMapping("")
	public Recipe updateRecipe(@RequestBody Recipe recipe) {
		return this.recipeService.update(recipe);
	}
	
	@DeleteMapping("/{id}")
	public Recipe deleteRecipe(@PathVariable int id) {
		return this.recipeService.deleteById(id);
	}
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
