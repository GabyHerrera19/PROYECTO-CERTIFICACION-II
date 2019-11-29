package com.gestion.parqueadero.app.web.models.services;

import java.util.List;

import com.gestion.parqueadero.app.web.models.entities.Estacionamiento;

public interface IEstacionamientoService {
	
			//Este metodo crea un nuevo registro de Estacionamiento
			//o actualiza un registro anterior
			public void save (Estacionamiento estacionamiento);
			
			public Estacionamiento findById(Integer id);
			
			public void delete(Integer id);
			
			public List<Estacionamiento> findAll();

}
