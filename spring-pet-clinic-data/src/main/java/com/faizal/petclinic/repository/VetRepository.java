package com.faizal.petclinic.repository;

import org.springframework.data.repository.CrudRepository;

import com.faizal.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
