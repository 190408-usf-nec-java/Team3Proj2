package com.services.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.Contain;
import com.revature.repositories.ContainRepository;
@Service
public class ContainServices {
	ContainRepository containRepository;

	@Inject
	public ContainServices(ContainRepository containRepository) {
		super();
		this.containRepository = containRepository;
	}

	public Contain getById(int id) {
		return this.containRepository.getById(id);
	}

	public Contain create(Contain contain) {
		return this.containRepository.create(contain);
	}

	public Contain update(Contain contain) {
		return this.containRepository.update(contain);
	}

	public Contain deleteById(int id) {
		return this.containRepository.deleteById(id);
	}

}
