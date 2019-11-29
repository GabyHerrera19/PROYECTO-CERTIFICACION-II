package com.gestion.parqueadero.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.parqueadero.app.web.models.dao.IVehiculo;
import com.gestion.parqueadero.app.web.models.entities.Vehiculo;
import com.gestion.parqueadero.app.web.models.services.IVehiculoService;

@Service
public class VehiculoService implements IVehiculoService{
	@Autowired//Inyeccion de dependencia
	private IVehiculo dao;

	@Override
	@Transactional //solo
	public void save(Vehiculo vehiculo) {
		try {
			dao.save(vehiculo);
		}
		catch(Exception ex) {
			throw ex;
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public Vehiculo findById(Integer id) {
		return dao.findById(id).get();
		
	}

	@Override
	@Transactional 
	public void delete(Integer id) {
		dao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Vehiculo> findAll() {
		return (List<Vehiculo>)dao.findAll();
	}
	
}
