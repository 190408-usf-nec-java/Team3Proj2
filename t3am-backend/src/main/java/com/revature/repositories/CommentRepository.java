package com.revature.repositories;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Comment;
@Repository

public class CommentRepository {

	SessionFactory sf;

	@Inject
	public CommentRepository(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Comment getById(int id) {
		Session session = sf.getCurrentSession();
		return session.get(Comment.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Comment create(Comment comment) {
		Session session = sf.getCurrentSession();
		session.save(comment);
		return comment;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Comment update(Comment comment) {
		Session session = sf.getCurrentSession();
		session.merge(comment);
		return comment;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Comment deleteById(int id) {
		Session session = sf.getCurrentSession();
		Comment comment = session.get(Comment.class, id);
		if (comment == null)
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		session.delete(comment);
		return comment;

	}
}
