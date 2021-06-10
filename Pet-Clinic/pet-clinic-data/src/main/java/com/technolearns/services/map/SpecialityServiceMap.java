package com.technolearns.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.technolearns.model.Speciality;
import com.technolearns.services.SpecialityService;

@Service
@Profile({ "default", "map" })
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {

	@Override
	public Speciality save(Speciality object) {
		return super.save(object);
	}

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
