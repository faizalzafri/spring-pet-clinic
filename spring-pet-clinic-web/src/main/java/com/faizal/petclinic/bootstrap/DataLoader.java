package com.faizal.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.faizal.petclinic.model.Owner;
import com.faizal.petclinic.model.Pet;
import com.faizal.petclinic.model.PetType;
import com.faizal.petclinic.model.Vet;
import com.faizal.petclinic.service.OwnerService;
import com.faizal.petclinic.service.PetTypeService;
import com.faizal.petclinic.service.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		// TODO Auto-generated constructor stub
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Owner owner1 = new Owner();
		owner1.setFirstname("Michael");
		owner1.setLastname("Weston");
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
		owner2.setFirstname("Fiona");
		owner2.setLastname("Glenanne");
		owner2.setAddress("owner2 address");
		owner2.setCity("owner2 city");
		owner2.setTelephone("owner2-123456");
		
		Pet pet2 = new Pet();
		pet2.setPetType(savedCatPetType);
		pet2.setOwner(owner2);
		pet2.setBirthDate(LocalDate.now());
		pet2.setName("Ygrite");

		ownerService.save(owner2);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstname("Sam");
		vet1.setLastname("Axe");

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstname("Jessie");
		vet2.setLastname("Porter");

		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}

}
