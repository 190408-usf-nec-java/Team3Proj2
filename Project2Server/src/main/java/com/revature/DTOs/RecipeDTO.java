package com.revature.DTOs;

import java.util.Arrays;
import java.util.List;

public class RecipeDTO {
	private String name;
	private String directions;
	private int user;
	private int[] tags;
	/*private List<String> utensils;*/
	private String[] ingredients;
	private String[] amounts;
	
	/*public void setUtensils(List<String> utensils) {
		this.utensils = utensils;
	}*/
	
	public void setUnits(List<String> units) {
		this.units = units;
	}
	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	public String[] getAmounts() {
		return amounts;
	}
	public void setAmounts(String[] amounts) {
		this.amounts = amounts;
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
	
	/*public List<String> getUtensils() {
		return utensils;
	}*/
	
	public List<String> getUnits() {
		return units;
	}
	@Override
	public String toString() {
		return "RecipeDTO [name=" + name + ", directions=" + directions + ", user=" + user + ", tags="
				+ "]";
	}
	
	
	public RecipeDTO(String name, String directions, int user, int[] tags, String[] ingredients, String[] amounts,
			List<String> units) {
		super();
		this.name = name;
		this.directions = directions;
		this.user = user;
		this.tags = tags;
		this.ingredients = ingredients;
		this.amounts = amounts;
		this.units = units;
	}
	public RecipeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
