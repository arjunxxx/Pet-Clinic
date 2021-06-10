package com.technolearns.services.springdatajpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.technolearns.model.Vet;
import com.technolearns.repositories.VetRepository;
import com.technolearns.services.VetService;

@Profile("springdatajpa")
@Service
public class VetSDJPAService implements VetService {

	private VetRepository vetRepository;

	public VetSDJPAService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		return new HashSet<Vet>((Collection<? extends Vet>) vetRepository.findAll());
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).orElse(null);
	}

	@Override
	public Vet save(Vet object) {

		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);

	}

	@Override
	public Vet findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
