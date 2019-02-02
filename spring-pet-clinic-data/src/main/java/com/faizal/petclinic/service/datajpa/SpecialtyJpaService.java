package com.faizal.petclinic.service.datajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.faizal.petclinic.model.Specialty;
import com.faizal.petclinic.repository.SpecialtyRepository;
import com.faizal.petclinic.service.SpecialtyService;

@Service
@Profile("springdatajpa")
public class SpecialtyJpaService implements SpecialtyService {

	private final SpecialtyRepository specialtyRepository;

	public SpecialtyJpaService(SpecialtyRepository specialtyRepository) {
		super();
		this.specialtyRepository = specialtyRepository;
	}

	@Override
	public Set<Specialty> findAll() {
		Set<Specialty> pets = new HashSet<Specialty>();
		specialtyRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public Specialty findById(Long id) {
		return specialtyRepository.findById(id).orElse(null);
	}

	@Override
	public Specialty save(Specialty object) {
		return specialtyRepository.save(object);
	}

	@Override
	public void delete(Specialty object) {
		specialtyRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		specialtyRepository.deleteById(id);
	}

}
