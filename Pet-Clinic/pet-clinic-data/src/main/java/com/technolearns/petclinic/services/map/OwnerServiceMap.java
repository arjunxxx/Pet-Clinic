package com.technolearns.petclinic.services.map;

import java.util.HashSet;
import java.util.Set;

import com.technolearns.petclinic.model.Owner;
import com.technolearns.petclinic.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long>{

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
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

}
