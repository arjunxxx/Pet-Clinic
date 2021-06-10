package com.technolearns.services.springdatajpa;

import java.util.Set;

import org.springframework.context.annotation.Profile;

import com.technolearns.model.Pet;
import com.technolearns.repositories.PetRepository;
import com.technolearns.services.PetService;

@Profile("springdatajpa")
public class PetSDJPAService implements PetService {

	private PetRepository petRepository;

	public PetSDJPAService(PetRepository petRepository) {
		super();
		this.petRepository = petRepository;
	}

	@Override
	public Set<Pet> findAll() {
		return (Set<Pet>) petRepository.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return petRepository.findById(id).orElse(null);
	}

	@Override
	public Pet save(Pet object) {

		return petRepository.save(object);
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);

	}

}
