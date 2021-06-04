package com.technolearns.repositories;

import org.springframework.data.repository.CrudRepository;

import com.technolearns.model.Owner;
import com.technolearns.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
