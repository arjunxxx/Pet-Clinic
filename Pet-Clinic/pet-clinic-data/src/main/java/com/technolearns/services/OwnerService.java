package com.technolearns.services;

import java.util.List;

import com.technolearns.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	List<Owner> findByLastName(String lastName);

}
