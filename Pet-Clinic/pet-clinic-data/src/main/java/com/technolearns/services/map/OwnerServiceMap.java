package com.technolearns.services.map;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.technolearns.model.Owner;
import com.technolearns.services.OwnerService;
import com.technolearns.services.PetService;
import com.technolearns.services.PetTypeService;

@Service
@Profile({ "default", "map" })
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private PetService petService;
	private PetTypeService petTypeService;

	public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Owner save(Owner object) {
		if (object != null) {
			if (object.getPets() != null && !object.getPets().isEmpty()) {
				object.getPets().forEach(pet -> {
					if (pet.getPetType() != null) {
						petTypeService.save(pet.getPetType());
					}
					petService.save(pet);
				});
			}
		}

		return super.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		return findAll().stream().filter(owner -> owner.getLastname().equals(lastName)).collect(Collectors.toList());
	}

}
