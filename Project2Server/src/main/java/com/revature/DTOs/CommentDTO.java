package com.revature.DTOs;

public class CommentDTO {
	private int user;
	private int recipe;
	private String digest;
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getRecipe() {
		return recipe;
	}
	public void setRecipe(int recipe) {
		this.recipe = recipe;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((digest == null) ? 0 : digest.hashCode());
		result = prime * result + recipe;
		result = prime * result + user;
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
		CommentDTO other = (CommentDTO) obj;
		if (digest == null) {
			if (other.digest != null)
				return false;
		} else if (!digest.equals(other.digest))
			return false;
		if (recipe != other.recipe)
			return false;
		if (user != other.user)
			return false;
		return true;
	}
	public CommentDTO(int user, int recipe, String digest) {
		super();
		this.user = user;
		this.recipe = recipe;
		this.digest = digest;
	}
	public CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
