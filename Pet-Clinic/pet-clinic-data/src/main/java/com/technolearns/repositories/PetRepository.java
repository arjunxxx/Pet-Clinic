package com.technolearns.repositories;

import org.springframework.data.repository.CrudRepository;

import com.technolearns.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
