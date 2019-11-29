package com.gestion.parqueadero.app.web.models.services;

import java.util.List;

import com.gestion.parqueadero.app.web.models.entities.Vehiculo;

public interface IVehiculoService {
	public void save (Vehiculo vehiculo);
	
	public Vehiculo findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Vehiculo> findAll();

}
