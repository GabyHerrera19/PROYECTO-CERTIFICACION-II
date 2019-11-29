package com.gestion.parqueadero.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.parqueadero.app.web.models.dao.IEstacionamiento;
import com.gestion.parqueadero.app.web.models.entities.Estacionamiento;
import com.gestion.parqueadero.app.web.models.services.IEstacionamientoService;

@Service
public class EstacionamientoService implements IEstacionamientoService{
	
	@Autowired//Inyeccion de dependencia
	private IEstacionamiento dao;

	@Override
	@Transactional //solo
	public void save(Estacionamiento estacionamiento) {
		dao.save(estacionamiento);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Estacionamiento findById(Integer id) {
		return dao.findById(id).get();
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Estacionamiento> findAll() {
		return (List<Estacionamiento>)dao.findAll();
	}

}
