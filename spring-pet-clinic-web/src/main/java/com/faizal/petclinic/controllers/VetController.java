package com.faizal.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.faizal.petclinic.service.VetService;

@Controller
public class VetController {

	private final VetService vetService;

	public VetController(VetService vetService) {
		super();
		this.vetService = vetService;
	}

	@RequestMapping({ "/vets", "/vets/", "/vets.html", "/vets/index", "/vets/index.html" })
	public String listVets(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index";
	}
}
