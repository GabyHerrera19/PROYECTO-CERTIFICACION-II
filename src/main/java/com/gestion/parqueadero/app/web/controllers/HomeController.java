package com.gestion.parqueadero.app.web.controllers;
import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@GetMapping(value="/")
	public String home(Model model) {
		model.addAttribute("title", "SGPE");
		model.addAttribute("description", "Sistema de Gestion de Parqueaderos. El sistema de gestión de Parqueaderos administra entradas y salidas de vehículos al parqueadero, mantiene un inventario de las áreas de estacionamiento, hace seguimiento a los horarios en que debería utilizarse el servicio por todos los usuarios, registra las incidencias de uso inadecuado del recurso brindado y muestra el valor a pagar por el estacionamiento. ");
		return "home";
	}
	
	@GetMapping(value="/login")
	public String login(@RequestParam(value="error", required=false) String error, 
			Model model, Principal principal, RedirectAttributes flash) {

		if(principal != null) {
			flash.addFlashAttribute("info", "El usuario ya tiene una sesión activa.");
			return "redirect:/";
		}		
		if(error != null) {
			model.addAttribute("error", "Usuario o contraseña incorrectas");
		}				
		return "login";
	}

}
