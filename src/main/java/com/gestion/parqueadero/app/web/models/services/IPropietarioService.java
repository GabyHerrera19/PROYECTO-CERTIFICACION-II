package com.gestion.parqueadero.app.web.models.services;

import java.util.List;

import com.gestion.parqueadero.app.web.models.entities.Propietario;

public interface IPropietarioService {
	public void save (Propietario propietario);
	
	public Propietario findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Propietario> findAll();
	

}
