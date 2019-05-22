package com.revature.repositories;

import javax.xml.ws.http.HTTPException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.User;
@Repository
public class UserRepository {
	@Autowired
SessionFactory sf;
	
	/*@Inject
	public UserRepository(SessionFactory sf) {
		this.sf = sf;
	}*/

	@Transactional(propagation = Propagation.REQUIRED)
	public User getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(User.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public User create(User user) {
		Session session = sf.getCurrentSession();
		session.save(user);
		return user;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public User update(User user) {
		Session session = sf.getCurrentSession();
		session.merge(user);
		return user;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public User  deleteById(int id) {
		Session session = sf.getCurrentSession();
		User user = session.get(User.class, id );
		if (user == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(user);
		return user;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public User getByUsername(String username) {
		Session session = sf.getCurrentSession();
		User u;
		try
		{
			u = (session.createQuery("Select u from User u where u.userName = :username",User.class).setParameter("username", username).list()).get(0);
		}
		catch(IndexOutOfBoundsException e)
		{
			throw new HTTPException(401);
		}
		return u;
	}


}
