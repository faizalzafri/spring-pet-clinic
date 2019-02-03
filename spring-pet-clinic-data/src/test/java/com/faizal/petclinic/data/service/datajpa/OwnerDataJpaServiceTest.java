package com.faizal.petclinic.data.service.datajpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.faizal.petclinic.model.Owner;
import com.faizal.petclinic.repository.OwnerRepository;
import com.faizal.petclinic.service.datajpa.OwnerDataJpaService;

public class OwnerDataJpaServiceTest {

	@Mock
	OwnerRepository ownerRepository;

	@InjectMocks
	OwnerDataJpaService ownerDataJpaService;

	Owner owner;
	private static final String lastName = "asdfasdf";
	private static final Long id = 1L;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		owner = new Owner();
		owner.setId(id);
		owner.setLastName(lastName);
	}

	@Test
	public void testFindAll() {
		Set<Owner> set = new HashSet<>();
		set.add(owner);
		set.add(new Owner());

		when(ownerDataJpaService.findAll()).thenReturn(set);

		Set<Owner> ownerSet = ownerDataJpaService.findAll();

		assertEquals(2, ownerSet.size());
		verify(ownerRepository, times(1)).findAll();

	}

	@Test
	public void testFindByLastName() {
		Set<Owner> set = new HashSet<>();
		set.add(owner);
		set.add(new Owner());

		when(ownerDataJpaService.findByLastName(any())).thenReturn(owner);

		Owner newOwner = ownerDataJpaService.findByLastName("asdfasdf");

		assertEquals(lastName, newOwner.getLastName());
		verify(ownerRepository, times(1)).findByLastName(any());
	}

	@Test
	public void findById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

		Owner owner = ownerDataJpaService.findById(id);

		assertNotNull(owner);
	}

	@Test
	public void findByIdNotFound() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

		Owner owner = ownerDataJpaService.findById(id);

		assertNull(owner);
	}

	@Test
	public void save() {
		Owner ownerToSave = new Owner();

		when(ownerRepository.save(any())).thenReturn(owner);

		Owner savedOwner = ownerDataJpaService.save(ownerToSave);

		assertNotNull(savedOwner);

		verify(ownerRepository).save(any());
	}

	@Test
	public void delete() {
		ownerDataJpaService.delete(owner);

		// default is 1 times
		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	public void deleteById() {
		ownerDataJpaService.deleteById(id);

		verify(ownerRepository).deleteById(anyLong());
	}

}
