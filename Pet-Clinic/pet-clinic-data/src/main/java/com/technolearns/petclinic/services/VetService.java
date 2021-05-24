package com.technolearns.petclinic.services;

import java.util.Set;

import com.technolearns.petclinic.model.Owner;
import com.technolearns.petclinic.model.Vet;

public interface VetService {
	
	
	Vet findByLastName(String lastName);
	
	Vet findById(Long id);
	
	Set<Vet> findAll();
	
	Vet save(Vet owner);
	

}
