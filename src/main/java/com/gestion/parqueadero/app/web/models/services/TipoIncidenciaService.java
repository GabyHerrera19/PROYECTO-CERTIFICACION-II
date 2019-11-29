package com.gestion.parqueadero.app.web.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.parqueadero.app.web.models.dao.ITipoIncidencia;
import com.gestion.parqueadero.app.web.models.entities.TipoIncidencia;

@Service
public class TipoIncidenciaService implements ITipoIncidenciaService{
	
	@Autowired//Inyeccion de dependencia
	private ITipoIncidencia dao;
	

	@Override
	@Transactional //solo
	public void save(TipoIncidencia tipoIncidencia) {
		dao.save(tipoIncidencia);
		
	}

	@Override
	@Transactional(readOnly=true)
	public TipoIncidencia findById(Integer id) {
		dao.findById(id).get();
		return null;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
		
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<TipoIncidencia> findAll() {
		
		return (List<TipoIncidencia>)dao.findAll();
	}
	
	

}
