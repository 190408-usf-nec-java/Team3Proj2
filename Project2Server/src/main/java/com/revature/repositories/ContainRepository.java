package com.revature.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Contain;
@Repository
public class ContainRepository {
	@Autowired
	SessionFactory sf;

	/*@Inject
	public ContainRepository(SessionFactory sf) {
		this.sf = sf;
	}*/

	@Transactional(propagation = Propagation.REQUIRED)
	public Contain getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Contain.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Contain create(Contain contain) {
		Session session = sf.getCurrentSession();
		session.save(contain);
		return contain;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Contain update(Contain contain) {
		Session session = sf.getCurrentSession();
		session.merge(contain);
		return contain;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Contain deleteById(int id) {
		Session session = sf.getCurrentSession();
		Contain contain = session.get(Contain.class, id);
		if (contain == null)
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(contain);
		return contain;

	}

}
