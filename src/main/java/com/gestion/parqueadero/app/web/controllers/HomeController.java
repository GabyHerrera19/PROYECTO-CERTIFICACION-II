package com.gestion.parqueadero.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@GetMapping(value="/")
	public String home(Model model) {
		model.addAttribute("tittle", "SGPE");
		model.addAttribute("description", "Sistema de Gestion de Parqueaderos");
		return "home";
	}

}
