package com.technolearns.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.technolearns.model.Owner;
import com.technolearns.model.Pet;
import com.technolearns.model.PetType;
import com.technolearns.model.Vet;
import com.technolearns.services.OwnerService;
import com.technolearns.services.PetTypeService;
import com.technolearns.services.VetService;



@Component
public class DataLoader implements CommandLineRunner {
	
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
		

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}





	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType saveDog = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType saveCat = petTypeService.save(cat);
		
		System.out.println("PetTypes Loaded");
		
		Owner owner1= new Owner();
		owner1.setFirstname("James");
		owner1.setLastname("Bond");
		owner1.setAddress("BoomBoom");
		owner1.setCity("Varkala");
		owner1.setTelephone("45894189321");
		
		
		Pet jamesPet= new Pet();
		jamesPet.setName("Tommy");
		jamesPet.setBirthday(LocalDate.now());
		jamesPet.setOwner(owner1);
		jamesPet.setPetType(saveDog);
		owner1.getPets().add(jamesPet);
		ownerService.save(owner1);
		
		
		
		
		Owner owner2= new Owner();
		owner2.setFirstname("Thomas");
		owner2.setLastname("Edison");
		owner1.setAddress("VooVoo");
		owner1.setCity("Varkala");
		owner1.setTelephone("54895618915");
		
		
		
		Pet thomasPet= new Pet();
		thomasPet.setName("Cathy");
		thomasPet.setBirthday(LocalDate.now());
		thomasPet.setPetType(saveCat);
		owner2.getPets().add(thomasPet);
		ownerService.save(owner2);
		
		System.out.println("Owners Loaded");

		Vet vet1  = new Vet();
		vet1.setFirstname("Jack");
		vet1.setLastname("Reacher");
		vetService.save(vet1);
		
		Vet vet2  = new Vet();
		vet2.setFirstname("Elon");
		vet2.setLastname("Musk");
		vetService.save(vet2);
		
		System.out.println("Vets Loaded");
		
		System.out.println("Owner Count = "+ownerService.findAll().size());
		System.out.println("Vet Count = "+vetService.findAll().size());
		System.out.println("PetType Count = "+petTypeService.findAll().size());
	
		
		
		
	}

}
