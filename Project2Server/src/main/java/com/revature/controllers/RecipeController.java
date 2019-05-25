package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.DTOs.RecipeDTO;
import com.revature.DTOs.SearchDTO;
import com.revature.entities.Contain;
import com.revature.entities.Recipe;
import com.revature.entities.Tag;
import com.revature.entities.User;
import com.revature.entities.Utensil;
import com.revature.services.IngredientServices;
import com.revature.services.RecipeServices;
import com.revature.services.TagServices;
import com.revature.services.UserServices;
import com.revature.services.UtensilServices;
@RestController // All methods infer @ResponseBody
@RequestMapping("recipe")
public class RecipeController {
	@Autowired
private RecipeServices recipeService;
	private UserServices userService;
	private IngredientServices ingredientService;
	private TagServices tagService;
	private UtensilServices utensilService;
	
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
	
	@PostMapping("/search/")
	public List<Recipe> searchByName(@RequestBody SearchDTO search) {
		List<Recipe> toRet = this.recipeService.getByName(search.getRecipe());
		if(toRet == null)
		{
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		return toRet;			
			
	}
	
	@PostMapping("/create/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean searchByName(@RequestBody RecipeDTO toAdd) {
		int uid = toAdd.getUser();
		User u = userService.getById(uid);
		ArrayList<Tag> tags = new ArrayList<Tag>();
		ArrayList<Utensil> utensils = new ArrayList<Utensil>();
		for(int i : toAdd.getTags())
		{
			tags.add(tagService.getById(i));
		}
		
		for(int i : toAdd.getUtensils())
		{
			utensils.add(utensilService.getById(i));
		}
		ArrayList<Contain> contains = new ArrayList<Contain>();
		
		int[] ingIds = toAdd.getIngredients();
		String[] ingUnits = toAdd.getUnits();
		String[] ingAmounts = toAdd.getAmounts();
		Recipe recipe = new Recipe(toAdd.getName(), toAdd.getDirections(), u, null, tags, utensils, null);
		for(int i = 0; i < ingIds.length; i++)
		{
			contains.add(new Contain(recipe, ingredientService.getById(ingIds[i]), ingAmounts[i] , ingUnits[i]));
		}
		recipe.setContains(contains);
		
		recipeService.create(recipe);
			
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
