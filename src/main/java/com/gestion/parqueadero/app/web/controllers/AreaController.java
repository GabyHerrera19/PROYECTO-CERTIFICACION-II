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

import com.gestion.parqueadero.app.web.models.entities.Area;
import com.gestion.parqueadero.app.web.models.entities.Vehiculo;
import com.gestion.parqueadero.app.web.models.services.IAreaService;



@Controller
@RequestMapping(value="/area") 
public class AreaController {
	
	@Autowired //Para crear inyeccion de dependencias entre el controlador y el servicio
	private IAreaService service; //La inyeccion de dependencias (autowired) se hace solo sobre interfaces
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		Area area = new Area();
		model.addAttribute("area", area); //El model reemplaza al ViewBag
		model.addAttribute("title", "Registro de nuevo tipo de área");
		return "area/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		Area area = service.findById(id);
		model.addAttribute("area", area);
		model.addAttribute("title", "Detalle de tipo de área");
		return "area/card";
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
		return "redirect:/area/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		Area area = service.findById(id);
		model.addAttribute("area", area);
		model.addAttribute("title", "Actualizar el área: "+ area.getNombre());
		return "area/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<Area> list = service.findAll();
		model.addAttribute("title", "Listado de tipos de áreas");
		model.addAttribute("list", list);
		return "area/list";
	}
	
	@PostMapping(value="/save")
	public String save(Area area, Model model, RedirectAttributes flash) {
		try {
			service.save(area); //El service ya sabe si es nuevo o un antiguo y lo actualiza
			flash.addFlashAttribute("success", "Registro guardado con éxito");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/area/list";
	}

}
