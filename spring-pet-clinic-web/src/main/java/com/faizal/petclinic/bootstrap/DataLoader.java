package com.faizal.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.faizal.petclinic.model.Owner;
import com.faizal.petclinic.model.Vet;
import com.faizal.petclinic.service.OwnerService;
import com.faizal.petclinic.service.VetService;
import com.faizal.petclinic.service.map.OwnerServiceMap;
import com.faizal.petclinic.service.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		// TODO Auto-generated constructor stub
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Owner owner1 = new Owner();
		owner1.setFirstname("Michael");
		owner1.setLastname("Weston");

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstname("Fiona");
		owner2.setLastname("Glenanne");

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
