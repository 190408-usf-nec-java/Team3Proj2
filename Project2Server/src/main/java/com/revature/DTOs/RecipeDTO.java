package com.revature.DTOs;

import java.util.Arrays;

public class RecipeDTO {
	private String name;
	private String directions;
	private int user;
	private int[] tags;
	private String[] utensils;
	private String[] ingredients;
	private String[] amounts;
	private String[] units;
	
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
	public String[] getUtensils() {
		return utensils;
	}
	public void setUtensils(String[] utensils) {
		this.utensils = utensils;
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
	public String[] getUnits() {
		return units;
	}
	public void setUnits(String[] units) {
		this.units = units;
	}
	@Override
	public String toString() {
		return "RecipeDTO [name=" + name + ", directions=" + directions + ", user=" + user + ", tags="
				+ Arrays.toString(tags) + ", utensils=" + Arrays.toString(utensils) + ", ingredients="
				+ Arrays.toString(ingredients) + ", amounts=" + Arrays.toString(amounts) + ", units="
				+ Arrays.toString(units) + "]";
	}
	public RecipeDTO(String name, String directions, int user, int[] tags, String[] utensils, String[] ingredients,
			String[] amounts, String[] units) {
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
