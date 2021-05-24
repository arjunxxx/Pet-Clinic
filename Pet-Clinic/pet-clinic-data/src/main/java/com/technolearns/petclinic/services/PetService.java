package com.technolearns.petclinic.services;

import java.util.Set;

import com.technolearns.petclinic.model.Owner;
import com.technolearns.petclinic.model.Pet;

public interface PetService {
	
	
	
	Pet findById(Long id);
	
	Set<Pet> findAll();
	
	Pet save(Pet owner);
	

}
