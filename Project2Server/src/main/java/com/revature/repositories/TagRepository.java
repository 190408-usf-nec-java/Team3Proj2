package com.revature.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Tag;
@Repository
public class TagRepository {

	@Autowired
	SessionFactory sf;

	/*@Inject
	public TagRepository(SessionFactory sf) {
		this.sf = sf;
	}*/

	@Transactional(propagation = Propagation.REQUIRED)
	public Tag getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Tag.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Tag create(Tag tag) {
		Session session = sf.getCurrentSession();
		session.save(tag);
		return tag;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Tag update(Tag tag) {
		Session session = sf.getCurrentSession();
		session.merge(tag);
		return tag;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Tag deleteById(int id) {
		Session session = sf.getCurrentSession();
		Tag tag = session.get(Tag.class, id);
		if (tag == null)
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(tag);
		return tag;

	}
}
