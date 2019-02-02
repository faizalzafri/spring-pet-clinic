package com.faizal.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.faizal.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
