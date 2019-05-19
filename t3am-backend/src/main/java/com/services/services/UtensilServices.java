package com.services.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.revature.entities.Utensil;
import com.revature.repositories.UtensilRepository;
@Service

public class UtensilServices {
	

	UtensilRepository utensilRepository;

	@Inject
	public UtensilServices(UtensilRepository utensilRepository) {
		super();
		this.utensilRepository = utensilRepository;
	}

	public Utensil getById(int id) {
		return this.utensilRepository.getById(id);
	}

	public Utensil create(Utensil utensil) {
		return this.utensilRepository.create(utensil);
	}

	public Utensil update(Utensil utensil) {
		return this.utensilRepository.update(utensil);
	}

	public Utensil deleteById(int id) {
		return this.utensilRepository.deleteById(id);
	}

}
