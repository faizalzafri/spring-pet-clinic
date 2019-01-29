package com.faizal.petclinic.service;

import java.util.Set;

import com.faizal.petclinic.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	
	Owner findById(Long Id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();

}
