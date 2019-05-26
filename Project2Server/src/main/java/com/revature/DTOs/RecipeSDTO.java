package com.revature.DTOs;

import java.util.List;

import com.revature.entities.Comment;

public class RecipeSDTO {
	private String name;
	private String ingredientlist;
	private String directions;
	private List<String> comments;
	public RecipeSDTO(String name, String ingredientlist, String directions, List<String> comments) {
		super();
		this.name = name;
		this.ingredientlist = ingredientlist;
		this.directions = directions;
		this.comments = comments;
	}
	public RecipeSDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIngredientlist() {
		return ingredientlist;
	}
	public void setIngredientlist(String ingredientlist) {
		this.ingredientlist = ingredientlist;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	
	
}
