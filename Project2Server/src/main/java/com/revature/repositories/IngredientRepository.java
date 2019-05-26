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
import com.revature.entities.User;
@Repository
public class IngredientRepository {
	@Autowired
	SessionFactory sf;

	/*@Inject
	public IngredientRepository(SessionFactory sf) {
		this.sf = sf;
	}*/

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

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Ingredient> getByName(String item) {
		Session session = sf.getCurrentSession();
		List<Ingredient> ing;
		System.out.println("grabbing ingredient " + item);
		try
		{
			ing = session.createQuery("Select i from Ingredient i where i.name like :criteria",Ingredient.class).setParameter("criteria", '%'+ item +'%').list();
			Ingredient i = ing.get(0);
		}
		catch(IndexOutOfBoundsException e)
		{
			return null;
		}
		return ing;
	}

	public Ingredient getByExactName(String string) {
		Session session = sf.getCurrentSession();
		List<Ingredient> ing;
		System.out.println("grabbing ingredient " + string);
		try
		{
			ing = session.createQuery("Select i from Ingredient i where i.name = :criteria",Ingredient.class).setParameter("criteria",string).list();
			Ingredient i = ing.get(0);
		}
		catch(IndexOutOfBoundsException e)
		{
			return null;
		}
		return ing.get(0);
	}


}
