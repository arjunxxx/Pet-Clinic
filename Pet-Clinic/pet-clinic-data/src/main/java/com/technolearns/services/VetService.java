package com.technolearns.services;

import java.util.Set;

import com.technolearns.model.Owner;
import com.technolearns.model.Vet;

public interface VetService extends CrudService<Vet, Long> {

	Vet findByLastName(String lastName);

}
