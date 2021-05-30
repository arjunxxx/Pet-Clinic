package com.technolearns.controller;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.technolearns.model.Vet;
import com.technolearns.services.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {
	
	
	private final VetService vetService;
	
	

	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}



	@RequestMapping({"","/index","/index.html"})
	public String index(Model model){
		Set<Vet> vets = vetService.findAll();
		model.addAttribute("vets",vets);
		return "vets/index";
	}
	
}
