package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Recipe;
import com.revature.repositories.RecipeRepository;
@Service
public class RecipeServices {
	@Autowired
	RecipeRepository recipeRepository;
	
	/*@Inject
	public RecipeServices(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}*/

	public Recipe getById(int id) {
		return this.recipeRepository.getById(id);
	}

	public Recipe create(Recipe recipe) {
		return this.recipeRepository.create(recipe);
	}

	public Recipe update(Recipe recipe) {
		return this.recipeRepository.update(recipe);
	}

	public Recipe deleteById(int id) {
		return this.recipeRepository.deleteById(id);
	}

	public List<Recipe> getByName(String recipe) {
		return this.recipeRepository.getByName(recipe);
	}

}
