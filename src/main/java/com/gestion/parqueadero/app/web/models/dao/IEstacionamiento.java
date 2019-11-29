package com.gestion.parqueadero.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.parqueadero.app.web.models.entities.Estacionamiento;

public interface IEstacionamiento extends CrudRepository<Estacionamiento, Integer>{

}
