package com.technolearns.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.technolearns.model.Owner;
import com.technolearns.services.PetService;
import com.technolearns.services.PetTypeService;

@ExtendWith(SpringExtension.class)
class OwnerServiceMapTest {

	private Long id_value = 1L;

	@Mock
	private PetService petService;

	@Mock
	private PetTypeService petTypeService;

	private OwnerServiceMap ownerServiceMap;

	final Long ownerId = 1L;
	final String lastName = "Smith";

	private Owner owner;

	@BeforeEach
	void setUp() throws Exception {

		ownerServiceMap = new OwnerServiceMap(petService, petTypeService);
		owner = ownerServiceMap.save(Owner.builder().id(ownerId).lastname(lastName).build());

	}

	@Test
	void testSaveOwner() {
		Owner owner2 = ownerServiceMap.save(Owner.builder().id(2L).lastname("John").build());
		Owner save = ownerServiceMap.save(owner2);
		assertEquals(owner2, save);

	}

	@Test
	void testFindAll() {
		Set<Owner> findAll = ownerServiceMap.findAll();
		assertEquals(findAll.size(), 1);
		assertEquals(findAll.stream().findFirst().get(), owner);
	}

	@Test
	void testFindByIdLong() {
		Owner findById = ownerServiceMap.findById(id_value);
		assertEquals(findById, owner);
	}

	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(owner);
		Owner findById = ownerServiceMap.findById(id_value);
		assertEquals(findById, null);
	}

	@Test
	void testFindByLastName() {
		List<Owner> findByLastName = ownerServiceMap.findByLastName(lastName);
		assertEquals(findByLastName.size(), 1);
	}

}
