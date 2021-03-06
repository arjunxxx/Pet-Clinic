package com.technolearns.services.springdatajpa;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.technolearns.model.Speciality;
import com.technolearns.repositories.SpecialityRepository;
import com.technolearns.services.SpecialityService;

@Profile("springdatajpa")
@Service
public class SpecialiySDJPAService implements SpecialityService {

	private SpecialityRepository specialityRepository;

	public SpecialiySDJPAService(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		return new HashSet<Speciality>((Collection<? extends Speciality>) specialityRepository.findAll());
	}

	@Override
	public Speciality findById(Long id) {
		return specialityRepository.findById(id).orElse(null);
	}

	@Override
	public Speciality save(Speciality object) {

		return specialityRepository.save(object);
	}

	@Override
	public void delete(Speciality object) {
		specialityRepository.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		specialityRepository.deleteById(id);

	}

}
