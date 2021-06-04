package com.technolearns.repositories;

import org.springframework.data.repository.CrudRepository;

import com.technolearns.model.Owner;
import com.technolearns.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
