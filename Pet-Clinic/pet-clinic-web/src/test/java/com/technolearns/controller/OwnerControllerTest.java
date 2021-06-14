package com.technolearns.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.technolearns.model.Owner;
import com.technolearns.services.OwnerService;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	private OwnerService ownerservice;

	@Mock
	private Model model;

	@InjectMocks
	private OwnerController ownerController;

	Set<Owner> owners = new HashSet<>();

	Owner owner;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		owner = Owner.builder().id(1L).lastname("Rakhi").build();
		owners.add(owner);
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	@Test
	void testIndex() throws Exception {

		when(ownerservice.findAll()).thenReturn(owners);
		mockMvc.perform(get("/owners"))
		.andExpect(status().isOk()).andExpect(view().name("owners/index"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("owners"));

	}

}
