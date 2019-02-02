package com.faizal.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.faizal.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {

}
