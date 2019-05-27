package com.revature.DTOs;

import java.util.Arrays;
import java.util.List;

public class RecipeDTO {
	private String name;
	private String directions;
	private int user;
	private int[] tags;
	private List<String> utensils;
	private List<String> ingredients;
	private List<String> amounts;
	
	public void setUtensils(List<String> utensils) {
		this.utensils = utensils;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public void setAmounts(List<String> amounts) {
		this.amounts = amounts;
	}
	public void setUnits(List<String> units) {
		this.units = units;
	}
	private List<String> units;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int[] getTags() {
		return tags;
	}
	public void setTags(int[] tags) {
		this.tags = tags;
	}
	
	public List<String> getUtensils() {
		return utensils;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public List<String> getAmounts() {
		return amounts;
	}
	public List<String> getUnits() {
		return units;
	}
	@Override
	public String toString() {
		return "RecipeDTO [name=" + name + ", directions=" + directions + ", user=" + user + ", tags="
				+ Arrays.toString(tags) + "]";
	}
	
	public RecipeDTO(String name, String directions, int user, int[] tags, List<String> utensils,
			List<String> ingredients, List<String> amounts, List<String> units) {
		super();
		this.name = name;
		this.directions = directions;
		this.user = user;
		this.tags = tags;
		this.utensils = utensils;
		this.ingredients = ingredients;
		this.amounts = amounts;
		this.units = units;
	}
	public RecipeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
