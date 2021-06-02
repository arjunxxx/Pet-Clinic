package com.technolearns.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.technolearns.model.Vet;
import com.technolearns.services.SpecialityService;
import com.technolearns.services.VetService;
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{
	
	private SpecialityService specialityService;
	
	

	public VetServiceMap(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Vet save(Vet object) {
		if(object!=null&&object.getSpecialities()!=null&&!object.getSpecialities().isEmpty()) {
			object.getSpecialities().forEach(speciality->{
				specialityService.save(speciality);					
			});
			
		}
		return super.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	} 
 
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}
    
	@Override
	public void delete(Vet object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Vet findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
}
