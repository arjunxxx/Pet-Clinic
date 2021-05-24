package com.technolearns.petclinic.services;

import java.util.Set;

import com.technolearns.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

}
