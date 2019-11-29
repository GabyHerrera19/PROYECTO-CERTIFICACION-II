package com.gestion.parqueadero.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestion.parqueadero.app.web.models.entities.Estacionamiento;
import com.gestion.parqueadero.app.web.models.entities.Vehiculo;
import com.gestion.parqueadero.app.web.models.services.IEstacionamientoService;



@Controller
@RequestMapping(value="/estacionamiento")
public class EstacionamientoController {
	@Autowired //Para crear inyeccion de dependencias entre el controlador y el servicio
	private  IEstacionamientoService service;
	
	

	@GetMapping(value="/create") 
	public String create(Model model) {
		Estacionamiento estacionamiento = new Estacionamiento();
		model.addAttribute("estacionamiento", estacionamiento); //El model reemplaza al ViewBag
		model.addAttribute("title", "Registro de nuevo estacionamiento");
		return "estacionamiento/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		Estacionamiento estacionamiento = service.findById(id);
		model.addAttribute("estacionamiento", estacionamiento);
		model.addAttribute("title", "Detalle de estacionamiento");
		return "estacionamiento/card";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Integer id, Model model, RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo eliminarse"); //El model sirve para la misma vista no si se cambia de vista
			ex.getStackTrace();
		}
		return "redirect:/estacionamiento/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Estacionamiento estacionamiento = service.findById(id);
		model.addAttribute("estacionamiento", estacionamiento);
		model.addAttribute("title", "Actualizar estacionamiento: " + estacionamiento.getNumero());
		return "estacionamiento/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Estacionamiento> list = service.findAll();
		model.addAttribute("title", "Listado de estacionamientos");
		model.addAttribute("list", list);
		return "estacionamiento/list";
	}
	

	@PostMapping(value="save")
	public String save(Estacionamiento estacionamiento, Model model, RedirectAttributes flash) {
		try {
			service.save(estacionamiento); //El service ya sabe si es nuevo o un antiguo y lo actualiza
			flash.addFlashAttribute("success", "Registro guardado con éxito");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/estacionamiento/list";
	}


}
