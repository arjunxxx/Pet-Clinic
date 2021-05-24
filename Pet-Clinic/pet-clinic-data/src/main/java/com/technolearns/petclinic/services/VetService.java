package com.technolearns.petclinic.services;

import java.util.Set;

import com.technolearns.petclinic.model.Owner;
import com.technolearns.petclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {

	Vet findByLastName(String lastName);

}
