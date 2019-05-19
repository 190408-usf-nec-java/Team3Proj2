package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Recipe;
@Repository

public class RecipeRepository {

	SessionFactory sf;

	@Inject
	public RecipeRepository(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Recipe getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Recipe.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Recipe create(Recipe recipe) {
		Session session = sf.getCurrentSession();
		session.save(recipe);
		return recipe;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Recipe update(Recipe recipe) {
		Session session = sf.getCurrentSession();
		session.merge(recipe);
		return recipe;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Recipe deleteById(int id) {
		Session session = sf.getCurrentSession();
		Recipe recipe = session.get(Recipe.class, id);
		if (recipe == null)
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(recipe);
		return recipe;

	}
}
