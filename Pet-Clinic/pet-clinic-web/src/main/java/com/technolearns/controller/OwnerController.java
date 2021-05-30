package com.technolearns.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.technolearns.model.Owner;
import com.technolearns.services.OwnerService;

@Controller
@RequestMapping("/owners")
public class OwnerController {
	
 
	private final OwnerService ownerservice;
	
	
	
	
	public OwnerController(OwnerService ownerservice) {
		super();
		this.ownerservice = ownerservice;
	}




	@RequestMapping({"","/index","/index.html"})
	public String index(Model model){
	    Set<Owner> owners = ownerservice.findAll();	
	    model.addAttribute("owners",owners);
		return "owners/index";
	}
	
}
