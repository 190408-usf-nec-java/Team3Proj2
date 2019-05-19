package com.revature.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@OneToMany (fetch=FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.DETACH})
	@JoinColumn(name = "ingredientC_id")
	private List<Contain> contains;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contain> getContains() {
		return contains;
	}

	public void setContains(List<Contain> contains) {
		this.contains = contains;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", contains=" + contains + "]";
	}

	public Ingredient(int id, String name, List<Contain> contains) {
		super();
		this.id = id;
		this.name = name;
		this.contains = contains;
	}

	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
