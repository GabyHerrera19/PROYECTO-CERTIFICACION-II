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

import com.gestion.parqueadero.app.web.models.entities.Uso;
import com.gestion.parqueadero.app.web.models.services.IUsoService;



@Controller
@RequestMapping(value="/uso")
public class UsoController {
	
	@Autowired //Para crear inyeccion de dependencias entre el controlador y el servicio
	private  IUsoService service;
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Uso uso = new Uso();
		model.addAttribute("uso", uso); //El model reemplaza al ViewBag
		model.addAttribute("title", "Registro de nuevo uso");
		return "uso/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		Uso uso = service.findById(id);
		model.addAttribute("uso", uso);
		model.addAttribute("title", "Detalle de uso");
		return "uso/card";
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
		return "redirect:/uso/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Uso uso = service.findById(id);
		model.addAttribute("paciente", uso);
		model.addAttribute("title", "Actualizar paciente: " + uso.getIncidencia());
		return "uso/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Uso> list = service.findAll();
		model.addAttribute("title", "Listado de usos");
		model.addAttribute("list", list);
		return "uso/list";
	}
	
	@PostMapping(value="/save")
	public String save(Uso uso, Model model, RedirectAttributes flash) {
		try {
			service.save(uso); //El service ya sabe si es nuevo o un antiguo y lo actualiza
			flash.addFlashAttribute("success", "Registro guardado con éxito");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/uso/list";
	}

}
