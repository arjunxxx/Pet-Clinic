package com.technolearns.services.springdatajpa;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.technolearns.model.Owner;
import com.technolearns.repositories.OwnerRepository;
import com.technolearns.repositories.PetRepository;
import com.technolearns.repositories.PetTypeRepository;
import com.technolearns.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJPAService implements OwnerService {

	private final OwnerRepository ownerRepository;

	private final PetRepository petRepository;

	private final PetTypeRepository petTypeRepository;

	public OwnerSDJPAService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository,
			PetRepository petRepository) {
		super();
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {

		return (Set<Owner>) ownerRepository.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(Owner object) {

		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);

	}

	@Override
	public Owner findByLastName(String lastName) {

		return ownerRepository.findByLastname(lastName);
	}

}
