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
import com.revature.DTOs.RecipeSDTO;
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
	public List<RecipeSDTO> searchByName(@RequestBody SearchDTO search) {
		List<Recipe> toRet = this.recipeService.getByName(search.getRecipe());
		List<RecipeSDTO> returning = new ArrayList<RecipeSDTO>();
		
		for(Recipe r : toRet)
		{
			RecipeSDTO toAdd = new RecipeSDTO();
			toAdd.setDirections(r.getDirections());
			String ingredientslist = "";
			for(Contain c : r.getContains())
			{
				ingredientslist += c.toString()+ "\n";
			}
			toAdd.setIngredientlist(ingredientslist);
			toAdd.setName(r.getName());
			
		}
		if(toRet == null)
		{
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		return returning;			
			
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
		
		for(String i : toAdd.getUtensils())
		{
			utensils.add(utensilService.getByName(i));
		}
		/*ArrayList<Contain> contains = new ArrayList<Contain>();
		
		List<String> ingIds = toAdd.getIngredients();
		List<String> ingUnits = toAdd.getUnits();
		List<String> ingAmounts = toAdd.getAmounts();
		Recipe recipe = new Recipe(toAdd.getName(), toAdd.getDirections(), u, null, tags, utensils, null);
		for(int i = 0; i < ingIds.size(); i++)
		{
			contains.add(new Contain(recipe, ingredientService.getIdbyName(ingIds.get(i)), ingAmounts.get(i) , ingUnits.get(i)));
		}
		recipe.setContains(contains);*/
		
		recipeService.create(recipe);
		return true;
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
