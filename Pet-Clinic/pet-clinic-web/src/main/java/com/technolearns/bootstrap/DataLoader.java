package com.technolearns.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.technolearns.model.Owner;
import com.technolearns.model.Vet;
import com.technolearns.services.OwnerService;
import com.technolearns.services.VetService;



@Component
public class DataLoader implements CommandLineRunner {
	
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	
	
	
	

	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}





	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1= new Owner();
		owner1.setFirstname("James");
		owner1.setLastname("Bond");
		ownerService.save(owner1);
		
		Owner owner2= new Owner();
		owner2.setFirstname("Thomas");
		owner2.setLastname("Edison");
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
		
		
		
	}

}
