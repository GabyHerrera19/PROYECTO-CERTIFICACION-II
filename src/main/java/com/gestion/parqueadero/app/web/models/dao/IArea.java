package com.gestion.parqueadero.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.parqueadero.app.web.models.entities.Area;

public interface IArea extends CrudRepository<Area, Integer>{

}
