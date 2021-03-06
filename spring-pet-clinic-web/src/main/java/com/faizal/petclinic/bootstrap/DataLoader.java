package com.faizal.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.faizal.petclinic.model.Owner;
import com.faizal.petclinic.model.Pet;
import com.faizal.petclinic.model.PetType;
import com.faizal.petclinic.model.Specialty;
import com.faizal.petclinic.model.Vet;
import com.faizal.petclinic.model.Visit;
import com.faizal.petclinic.service.OwnerService;
import com.faizal.petclinic.service.PetTypeService;
import com.faizal.petclinic.service.SpecialtyService;
import com.faizal.petclinic.service.VetService;
import com.faizal.petclinic.service.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService, VisitService visitService) {
		// TODO Auto-generated constructor stub
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if (count == 0)
			loadData();
	}

	/**
	 * loading startup data
	 */
	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		;
		Specialty savedradiology = specialtyService.save(radiology);

		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty savedsurgery = specialtyService.save(surgery);

		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty saveddentistry = specialtyService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("owner1 address");
		owner1.setCity("owner1 city");
		owner1.setTelephone("owner1-123456");

		Pet pet1 = new Pet();
		pet1.setPetType(savedDogPetType);
		pet1.setOwner(owner1);
		pet1.setBirthDate(LocalDate.now());
		pet1.setName("Jordan");

		owner1.getPets().add(pet1);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("owner2 address");
		owner2.setCity("owner2 city");
		owner2.setTelephone("owner2-123456");

		Pet pet2 = new Pet();
		pet2.setPetType(savedCatPetType);
		pet2.setOwner(owner2);
		pet2.setBirthDate(LocalDate.now());
		pet2.setName("Ygrite");
		
		owner2.getPets().add(pet2);

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialties().add(savedradiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialties().add(savedsurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
		
		System.out.println(pet1.getId());
		System.out.println(pet2.getId());
		
		System.out.println("Loaded Visits....");
		
		Visit dogVisit = new Visit();
		dogVisit.setPet(pet2);
		dogVisit.setDate(LocalDate.now());
		dogVisit.setDescription("Coughing Doggo");

		visitService.save(dogVisit);
	}

}
