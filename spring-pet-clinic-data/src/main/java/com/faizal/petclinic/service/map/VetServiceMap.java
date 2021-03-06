package com.faizal.petclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.faizal.petclinic.model.Specialty;
import com.faizal.petclinic.model.Vet;
import com.faizal.petclinic.service.SpecialtyService;
import com.faizal.petclinic.service.VetService;

@Service
@Profile({ "default", "map" })
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialtyService specialtyService;

	public VetServiceMap(SpecialtyService specialtyService) {
		super();
		this.specialtyService = specialtyService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findByID(id);
	}

	@Override
	public Vet save(Vet object) {

		if (object.getSpecialties().size() > 0) {
			object.getSpecialties().forEach(speciality -> {
				if (speciality.getId() == null) {
					Specialty savedSpecialty = specialtyService.save(speciality);
					speciality.setId(savedSpecialty.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}