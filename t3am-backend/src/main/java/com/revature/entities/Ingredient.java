package com.revature.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@ManyToMany
	@JoinTable(name = "recipes_ingredients", joinColumns = {
			@JoinColumn(name = "ingredient_id") }, inverseJoinColumns = { @JoinColumn(name = "recipe_id") })
	private List<Recipe> recipes;

}
