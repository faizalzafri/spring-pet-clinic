package com.faizal.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.faizal.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
