package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Ingredient;

public class IngredientRepository {

	SessionFactory sf;

	@Inject
	public IngredientRepository(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Ingredient getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Ingredient.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Ingredient create(Ingredient ingredient) {
		Session session = sf.getCurrentSession();
		session.save(ingredient);
		return ingredient;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Ingredient update(Ingredient ingredient) {
		Session session = sf.getCurrentSession();
		session.merge(ingredient);
		return ingredient;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Ingredient deleteById(int id) {
		Session session = sf.getCurrentSession();
		Ingredient ingredient = session.get(Ingredient.class, id);
		if (ingredient == null)
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(ingredient);
		return ingredient;

	}

}
