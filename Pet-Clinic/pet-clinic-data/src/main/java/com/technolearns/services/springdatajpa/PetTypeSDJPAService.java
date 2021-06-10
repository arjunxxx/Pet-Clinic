package com.technolearns.services.springdatajpa;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.technolearns.model.PetType;
import com.technolearns.repositories.PetTypeRepository;
import com.technolearns.services.PetTypeService;

@Profile("springdatajpa")
@Service
public class PetTypeSDJPAService implements PetTypeService {

	private PetTypeRepository petTypeRepository;

	public PetTypeSDJPAService(PetTypeRepository petTypeRepository) {
		super();
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<PetType> findAll() {
		return (Set<PetType>) petTypeRepository.findAll();
	}

	@Override
	public PetType findById(Long id) {
		return petTypeRepository.findById(id).orElse(null);
	}

	@Override
	public PetType save(PetType object) {

		return petTypeRepository.save(object);
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);

	}

}
