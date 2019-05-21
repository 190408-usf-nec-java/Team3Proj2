package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Utensil;
import com.revature.repositories.UtensilRepository;
@Service
public class UtensilServices {
	@Autowired
	UtensilRepository utensilRepository;

	/*@Inject
	public UtensilServices(UtensilRepository utensilRepository) {
		super();
		this.utensilRepository = utensilRepository;
	}*/

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
