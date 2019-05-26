package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/search/")
	public List<String> searchByName(@RequestBody SearchDTO search) {
		List<Ingredient> toRet = this.ingredientService.getByName(search.getItem());
		System.out.println("searching " + search.getItem());
		List<String> returning = new ArrayList<String>();
		
		if(toRet == null)
		{
			System.out.println("didnt find item");
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		System.out.println("found item");
		for(Ingredient i : toRet)
		{
			returning.add(i.getName());
		}
		
		return returning;			
			
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
		return this.ingredientService.create(ingredient);
	}
	

	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<String> handleClientError(HttpClientErrorException e) {
		return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
	}

}
