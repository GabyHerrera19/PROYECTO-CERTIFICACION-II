package com.gestion.parqueadero.app.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestion.parqueadero.app.web.models.entities.Propietario;
import com.gestion.parqueadero.app.web.models.entities.Vehiculo;
import com.gestion.parqueadero.app.web.models.services.IPropietarioService;
import com.gestion.parqueadero.app.web.models.services.IVehiculoService;

@Controller
@RequestMapping(value = "/vehiculo")
public class VehiculoController {
	@Autowired // Para crear inyeccion de dependencias entre el controlador y el servicio
	private IVehiculoService service;
	@Autowired
    private IPropietarioService srvPropietario;
	
	
	@GetMapping(value = "/create")
	public String create(Model model) {
		Vehiculo vehiculo = new Vehiculo();
		model.addAttribute("vehiculo", vehiculo); // El model reemplaza al ViewBag
		model.addAttribute("title", "Registro de nuevo vehiculo");
		
		List<Propietario> propietarios = srvPropietario.findAll();
        model.addAttribute("propietarios", propietarios); 
		
		return "vehiculo/form";
	}

	@GetMapping(value = "/retrive/{id}")
	public String retrive(@PathVariable(value = "id") Integer id, Model model) {
		Vehiculo vehiculo = service.findById(id);
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("title", "Detalle de vehiculo");
		return "vehiculo/card";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Integer id, Model model, RedirectAttributes flash) {
		try {
			service.delete(id);
			flash.addFlashAttribute("success", "El registro se eliminó exitosamente");
		} catch (Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo eliminarse"); // El model sirve para la misma vista no
																				// si se cambia de vista
			ex.getStackTrace();
		}
		return "redirect:/vehiculo/list";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Integer id, Model model) {
		Vehiculo vehiculo = service.findById(id);
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("title", "Actualizar el vehículo: " + vehiculo.getPlaca());
		
		List<Propietario> propietarios = srvPropietario.findAll();
        model.addAttribute("propietarios", propietarios); 
		
		return "vehiculo/form";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Vehiculo> list = service.findAll();
		model.addAttribute("list", list);
		model.addAttribute("title", "Listado de vehículos");
		return "vehiculo/list";
	}

	

	@PostMapping(value = "/save")
	public String save(@Valid Vehiculo vehiculo, BindingResult result, Model model, RedirectAttributes flash) {
		try {
			if (result.hasErrors()) {
				model.addAttribute("tittle", "Error al Guardar");
				
				List<Propietario> propietarios = srvPropietario.findAll();
		        model.addAttribute("propietarios", propietarios); 
				
				return "vehiculo/form";
			}
			service.save(vehiculo);
			flash.addFlashAttribute("success", "El registro fue guardado con éxito.");
		} catch (Exception ex) {
			flash.addFlashAttribute("error", "El registro no pudo ser guardado.");
		}
		return "redirect:/vehiculo/list";
	}

}
