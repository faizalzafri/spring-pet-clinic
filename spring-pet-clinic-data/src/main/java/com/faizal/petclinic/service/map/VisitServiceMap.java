package com.faizal.petclinic.service.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.faizal.petclinic.model.Pet;
import com.faizal.petclinic.model.Visit;
import com.faizal.petclinic.service.PetService;
import com.faizal.petclinic.service.PetTypeService;
import com.faizal.petclinic.service.VisitService;

@Service
@Profile({ "default", "map" })
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public VisitServiceMap(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Visit> findAll() {
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findByID(id);
	}

	@Override
	public Visit save(Visit object) {

		if (object.getPet() == null || object.getPet().getOwner() == null || object.getPet().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
		return super.save(object);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
