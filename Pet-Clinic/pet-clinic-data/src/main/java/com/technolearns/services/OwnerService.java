package com.technolearns.services;

import java.util.Set;

import com.technolearns.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);

}
