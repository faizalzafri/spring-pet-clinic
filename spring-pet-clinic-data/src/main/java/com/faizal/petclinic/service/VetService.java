package com.faizal.petclinic.service;

import java.util.Set;

import com.faizal.petclinic.model.Pet;
import com.faizal.petclinic.model.Vet;

public interface VetService {
	
	Vet findById(Long Id);

	Pet save(Vet vet);

	Set<Vet > findAll();
}