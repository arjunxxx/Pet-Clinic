package com.technolearns.repositories;

import org.springframework.data.repository.CrudRepository;

import com.technolearns.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastname(String lastName);

}
