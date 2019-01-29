package com.faizal.petclinic.service;

import java.util.Set;

import com.faizal.petclinic.model.Pet;

public interface PetService {

	Pet findById(Long Id);

	Pet save(Pet pet);

	Set<Pet> findAll();
}
