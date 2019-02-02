package com.faizal.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.faizal.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
