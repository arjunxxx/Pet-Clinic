package com.technolearns.repositories;

import org.springframework.data.repository.CrudRepository;

import com.technolearns.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

	Vet findByLastname(String lastName);
}
