package com.gestion.parqueadero.app.web.models.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.parqueadero.app.web.models.dao.IUso;
import com.gestion.parqueadero.app.web.models.entities.Uso;

@Service
public class UsoService implements IUsoService{
	
	@Autowired//Inyeccion de dependencia
	private IUso dao;
	
	@Override
	@Transactional //solo
	public void save(Uso uso) {
		dao.save(uso);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Uso findById(Integer id) {
		return dao.findById(id).get();
		
	}

	@Override
	@Transactional //solo
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Uso> findAll() {
		// TODO Auto-generated method stub
		return (List<Uso>)dao.findAll();
	}


}
