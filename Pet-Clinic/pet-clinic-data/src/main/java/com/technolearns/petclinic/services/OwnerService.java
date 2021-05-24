package com.technolearns.petclinic.services;

import java.util.Set;

import com.technolearns.petclinic.model.Owner;

public interface OwnerService {
	
	
	Owner findByLastName(String lastName);
	
	Owner findById(Long id);
	
	Set<Owner> findAll();
	
	Owner save(Owner owner);
	

}
