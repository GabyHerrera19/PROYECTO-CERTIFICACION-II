package gestion.parqueadero.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.parqueadero.app.web.models.entities.Propietario;


public interface IPropietario extends CrudRepository<Propietario, Integer>{

}
