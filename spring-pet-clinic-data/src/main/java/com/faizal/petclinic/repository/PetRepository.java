package com.faizal.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.faizal.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
