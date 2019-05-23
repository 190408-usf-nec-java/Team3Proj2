package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Ingredient;
import com.revature.entities.Recipe;
@Repository
public class RecipeRepository {
	@Autowired
	SessionFactory sf;

	/*@Inject
	public RecipeRepository(SessionFactory sf) {
		this.sf = sf;
	}*/

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

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Recipe> getByName(String recipe) {
		Session session = sf.getCurrentSession();
		List<Recipe> rec;
		try
		{
			rec = session.createQuery("Select r from Recipe r where r.name like :criteria",Recipe.class).setParameter("criteria", '%'+ recipe +'%').list();
			Recipe r = rec.get(0);
		}
		catch(IndexOutOfBoundsException e)
		{
			return null;
		}
		return rec;
	}


}
