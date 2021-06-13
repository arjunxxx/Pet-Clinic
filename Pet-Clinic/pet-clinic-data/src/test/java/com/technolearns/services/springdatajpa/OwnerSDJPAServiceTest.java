package com.technolearns.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.technolearns.model.Owner;
import com.technolearns.repositories.OwnerRepository;
import com.technolearns.repositories.PetRepository;
import com.technolearns.repositories.PetTypeRepository;

@ExtendWith(SpringExtension.class)
class OwnerSDJPAServiceTest {

	final Long ownerId = 1L;
	final String lastName = "Smith";

	Owner returnOwner;

	@Mock
	private OwnerRepository ownerRepository;

	@Mock
	private PetRepository petRepository;

	@Mock
	private PetTypeRepository petTypeRepository;

	@InjectMocks
	private OwnerSDJPAService ownerSDJPAService;

	@BeforeEach
	void setUp() throws Exception {
		returnOwner = Owner.builder().id(ownerId).lastname(lastName).build();
	}

	@Test
	void testFindAll() {

		Set<Owner> owners = new HashSet<>();
		owners.add(Owner.builder().id(2L).lastname("Bob").build());
		owners.add(Owner.builder().id(3L).lastname("Jim").build());
		when(ownerRepository.findAll()).thenReturn(owners);
		Set<Owner> findAll = ownerSDJPAService.findAll();
		assertEquals(findAll.size(), 2);
		verify(ownerRepository, times(1)).findAll();
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
		Owner findById = ownerSDJPAService.findById(ownerId);
		assertEquals(findById, returnOwner);
		verify(ownerRepository, times(1)).findById(anyLong());
	}

	@Test
	void testSave() {
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		Owner save = ownerSDJPAService.save(returnOwner);
		assertEquals(save, returnOwner);
		verify(ownerRepository, times(1)).save(any());
	}

	@Test
	void findByLastName() {
		List<Owner> ownersList = new ArrayList<Owner>();
		ownersList.add(returnOwner);
		when(ownerRepository.findByLastname(any())).thenReturn(ownersList);

		List<Owner> findByLastName = ownerSDJPAService.findByLastName(lastName);

		assertEquals(lastName, findByLastName.stream().findFirst().get().getLastname());

		verify(ownerRepository).findByLastname(any());
	}

	@Test
	void delete() {
		ownerSDJPAService.delete(returnOwner);
		verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void deleteById() {
		ownerSDJPAService.deleteById(ownerId);
		verify(ownerRepository).deleteById(anyLong());
	}
}
