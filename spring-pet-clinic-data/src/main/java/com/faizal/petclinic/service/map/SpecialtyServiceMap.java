package com.faizal.petclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.faizal.petclinic.model.Specialty;
import com.faizal.petclinic.service.SpecialtyService;

@Service
@Profile({ "default", "map" })
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
