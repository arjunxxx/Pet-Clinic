package com.technolearns.services.springdatajpa;

import java.util.Set;

import org.springframework.context.annotation.Profile;

import com.technolearns.model.Speciality;
import com.technolearns.repositories.SpecialityRepository;
import com.technolearns.services.SpecialityService;

@Profile("springdatajpa")
public class SpecialiySDJPAService implements SpecialityService {

	private SpecialityRepository specialityRepository;

	public SpecialiySDJPAService(SpecialityRepository specialityRepository) {
		super();
		this.specialityRepository = specialityRepository;
	}

	@Override
	public Set<Speciality> findAll() {
		return (Set<Speciality>) specialityRepository.findAll();
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
