package com.faizal.petclinic.service.map;

import java.util.Set;

import com.faizal.petclinic.model.Specialty;
import com.faizal.petclinic.service.SpecialtyService;

public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

	@Override
	public Set<Specialty> findAll() {

		return super.findAll();
	}

	@Override
	public Specialty findById(Long id) {

		return super.findByID(id);
	}

	@Override
	public Specialty save(Specialty object) {

		return super.save(object);
	}

	@Override
	public void delete(Specialty object) {

		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {

		super.deleteById(id);
	}

}
