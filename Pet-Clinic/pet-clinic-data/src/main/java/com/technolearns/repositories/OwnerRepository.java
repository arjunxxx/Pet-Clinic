package com.technolearns.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.technolearns.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	List<Owner> findByLastname(String lastName);

}
