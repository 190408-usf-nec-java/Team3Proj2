package com.revature.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	@ManyToMany
	@JoinTable(name = "recipes_tags", joinColumns = { @JoinColumn(name = "tag_id") }, inverseJoinColumns = {
			@JoinColumn(name = "recipe_id") })
	private List<Recipe> recipes;
	
	@ManyToMany
	@JoinTable(name = "ingredient_tags", joinColumns = { @JoinColumn(name = "tag_id") }, inverseJoinColumns = {
			@JoinColumn(name = "ingredient_id") })
	private List<Ingredient> ingredients;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (id != other.id)
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (recipes == null) {
			if (other.recipes != null)
				return false;
		} else if (!recipes.equals(other.recipes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", recipes=" + recipes + ", ingredients=" + ingredients + "]";
	}

	public Tag(int id, List<Recipe> recipes, List<Ingredient> ingredients) {
		super();
		this.id = id;
		this.recipes = recipes;
		this.ingredients = ingredients;
	}

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
