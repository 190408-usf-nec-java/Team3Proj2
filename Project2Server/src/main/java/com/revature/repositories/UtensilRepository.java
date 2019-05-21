package com.revature.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Utensil;
@Repository
public class UtensilRepository {
	@Autowired
	SessionFactory sf;

	/*@Inject
	public UtensilRepository(SessionFactory sf) {
		this.sf = sf;
	}*/

	@Transactional(propagation = Propagation.REQUIRED)
	public Utensil getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Utensil.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Utensil create(Utensil utensil) {
		Session session = sf.getCurrentSession();
		session.save(utensil);
		return utensil;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Utensil update(Utensil utensil) {
		Session session = sf.getCurrentSession();
		session.merge(utensil);
		return utensil;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Utensil deleteById(int id) {
		Session session = sf.getCurrentSession();
		Utensil utensil = session.get(Utensil.class, id);
		if (utensil == null)
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(utensil);
		return utensil;

	}

}
