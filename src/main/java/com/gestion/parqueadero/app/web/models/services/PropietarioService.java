package com.gestion.parqueadero.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.parqueadero.app.web.models.dao.IPropietario;
import com.gestion.parqueadero.app.web.models.entities.Propietario;

@Service
public class PropietarioService implements IPropietarioService{
	
	@Autowired//Inyeccion de dependencia
	private IPropietario dao;
	
	@Override
	@Transactional //solo
	public void save(Propietario propietario) {
		dao.save(propietario);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Propietario findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Propietario> findAll() {
		return(List<Propietario>)dao.findAll();
		
	}
	

}
