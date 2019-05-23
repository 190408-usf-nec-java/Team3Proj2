package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Tag;
import com.revature.repositories.TagRepository;
@Service
public class TagServices {
	
	@Autowired
	TagRepository tagRepository;

	/*@Inject
	public TagServices(TagRepository tagRepository) {
		super();
		this.tagRepository = tagRepository;
	}*/

	public Tag getById(int id) {
		return this.tagRepository.getById(id);
	}

	public Tag create(Tag tag) {
		return this.tagRepository.create(tag);
	}

	public Tag update(Tag tag) {
		return this.tagRepository.update(tag);
	}

	public Tag deleteById(int id) {
		return this.tagRepository.deleteById(id);
	}

}
