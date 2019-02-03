package com.faizal.petclinic.web.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.faizal.petclinic.controllers.OwnerController;
import com.faizal.petclinic.model.Owner;
import com.faizal.petclinic.service.OwnerService;

public class OwnerControllerTest {

	@Mock
	OwnerService ownerService;

	@InjectMocks
	OwnerController controller;

	Set<Owner> owners;

	MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		owners = new HashSet<>();
		Owner owner = new Owner();
		owner = new Owner();
		owner.setId(1L);
		Owner owner2 = new Owner();
		owner2 = new Owner();
		owner2.setId(2L);

		owners.add(owner);
		owners.add(owner2);

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testListOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(owners);
		mockMvc.perform(get("/owners")).andExpect(status().isOk()).andExpect(view().name("owners/index"))
				.andExpect(model().attributeExists("owners"));

	}

	@Test
	public void testFindOwners() throws Exception {
		mockMvc.perform(get("/owners/find")).andExpect(status().isOk()).andExpect(view().name("NotImplemented"));
		verifyZeroInteractions(ownerService);

	}

}
