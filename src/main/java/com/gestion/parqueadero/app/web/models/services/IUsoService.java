package com.gestion.parqueadero.app.web.models.services;

import java.util.List;

import com.gestion.parqueadero.app.web.models.entities.Uso;

public interface IUsoService {
public void save (Uso uso);
	
	public Uso findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Uso> findAll();

}
