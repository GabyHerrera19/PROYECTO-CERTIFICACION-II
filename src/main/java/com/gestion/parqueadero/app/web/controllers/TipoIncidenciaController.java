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

import com.gestion.parqueadero.app.web.models.entities.TipoIncidencia;
import com.gestion.parqueadero.app.web.models.services.ITipoIncidenciaService;


@Controller
@RequestMapping(value="/tipoincidencia")
public class TipoIncidenciaController {
	
	@Autowired //Para crear inyeccion de dependencias entre el controlador y el servicio
	private ITipoIncidenciaService service; //La inyeccion de dependencias (autowired) se hace solo sobre interfaces
	
	@GetMapping(value="/create") 
	public String create(Model model) {
		TipoIncidencia tipoincidencia = new TipoIncidencia();
		model.addAttribute("tipoincidencia", tipoincidencia); //El model reemplaza al ViewBag
		model.addAttribute("title", "Registro de nuevo tipo de incidencia");
		return "tipoincidencia/form";
	}
	
	@GetMapping(value="/retrive/{id}")
	public String retrive(@PathVariable(value="id") Integer id, Model model) {
		TipoIncidencia tipoincidencia = service.findById(id);
		model.addAttribute("tipoincidencia", tipoincidencia);
		model.addAttribute("title", "Detalle de tipo de incidencia");
		return "tipoincidencia/card";
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
		return "redirect:/tipoincidencia/list";
	}
	
	@GetMapping(value="/update/{id}")
	public String update(@PathVariable(value="id") Integer id, Model model) {
		TipoIncidencia tipoincidencia = service.findById(id);
		model.addAttribute("tipoincidencia", tipoincidencia);
		model.addAttribute("title", "Actualizar el tipo de incidencia: " + tipoincidencia.getTipo());
		return "tipoincidencia/form";
	}
	
	@GetMapping(value="/list")
	public String list(Model model) {
		List<TipoIncidencia> list = service.findAll();
		model.addAttribute("tittle", "Listado de tipos de incidencias");
		model.addAttribute("list", list);
		return "tipoincidencia/list";
	}
	
	@PostMapping(value="/save")
	public String save(TipoIncidencia tipoincidencia, Model model, RedirectAttributes flash) {
		try {
			service.save(tipoincidencia); //El service ya sabe si es nuevo o un antiguo y lo actualiza
			flash.addFlashAttribute("success", "Registro guardado con éxito");
		}catch(Exception ex) {
			flash.addFlashAttribute("error", "No se pudo guardar");
		}
		return "redirect:/tipoincidencia/list";
	}

}
