package com.faizal.petclinic.data.service.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.faizal.petclinic.model.Owner;
import com.faizal.petclinic.service.map.OwnerServiceMap;
import com.faizal.petclinic.service.map.PetServiceMap;
import com.faizal.petclinic.service.map.PetTypeMapService;

public class OwnerMapServiceTest {

	OwnerServiceMap ownerMapService;
	Owner owner = new Owner();

	final Long ownerId = 1L;

	@Before
	public void setUp() throws Exception {
		ownerMapService = new OwnerServiceMap(new PetTypeMapService(), new PetServiceMap());
		owner.setId(ownerId);
		owner.setLastName("asdfasdf");
		ownerMapService.save(owner);
	}

	@Test
	public void testFindAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	public void testFindById() {
		Owner owner = ownerMapService.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	public void testSaveOwner() {
		Long id = 1L;

		Owner newOwner = new Owner();
		newOwner.setId(id);

		ownerMapService.save(newOwner);

		assertEquals(id, ownerMapService.findById(id).getId());

	}

	@Test
	public void testDeleteOwner() {
		ownerMapService.delete(this.owner);
		assertEquals(0, ownerMapService.findAll().size());

	}

	@Test
	public void testDeleteByIdLong() {
		ownerMapService.deleteById(this.owner.getId());
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	public void testFindByLastName() {
		Owner asdf = ownerMapService.findByLastName("asdfasdf");
		assertEquals("asdfasdf", asdf.getLastName());


	}

}
