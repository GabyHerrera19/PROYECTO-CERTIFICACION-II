package com.gestion.parqueadero.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.parqueadero.app.web.models.dao.IArea;
import com.gestion.parqueadero.app.web.models.entities.Area;

@Service
public class AreaService implements IAreaService{
	
	@Autowired//Inyeccion de dependencia
	private IArea dao;
	
	@Override
	@Transactional //solo
	public void save(Area area) {
		dao.save(area);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Area findById(Integer id) {
		
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Area> findAll() {
		return(List<Area>)dao.findAll();
		
	}

}
