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

import com.gestion.parqueadero.app.web.models.entities.Propietario;
import com.gestion.parqueadero.app.web.models.services.IPropietarioService;



@Controller
@RequestMapping(value="/propietario")
public class PropietarioController {
	
	@Autowired //Para crear inyeccion de dependencias entre el controlador y el servicio
	private  IPropietarioService service;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Propietario propietario = new Propietario();
		model.addAttribute("propietario", propietario); //El model reemplaza al ViewBag
		model.addAttribute("title", "Registro de nuevo propietario");
		return "propietario/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		Propietario propietario = service.findById(id);
		model.addAttribute("paciente", propietario);
		model.addAttribute("title", "Detalle de propietario");
		return "propietario/card";
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
		return "redirect:/propietario/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Propietario propietario = service.findById(id);
		model.addAttribute("propietario", propietario);
		model.addAttribute("title", "Actualizar propietario: " + propietario.getNombre());
		return "propietario/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Propietario> list = service.findAll();
		model.addAttribute("tittle", "Listado de propietarios");
		model.addAttribute("list", list);
		return "propietario/list";
	}
	
	@PostMapping(value="/save")
	public String save(Propietario propietario, Model model, RedirectAttributes flash) {
		try {
			service.save(propietario); //El service ya sabe si es nuevo o un antiguo y lo actualiza
			flash.addFlashAttribute("success", "Registro guardado con éxito");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/propietario/list";
	}

}
