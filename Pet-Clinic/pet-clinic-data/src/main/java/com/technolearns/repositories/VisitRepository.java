package com.technolearns.repositories;

import org.springframework.data.repository.CrudRepository;

import com.technolearns.model.Owner;
import com.technolearns.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
