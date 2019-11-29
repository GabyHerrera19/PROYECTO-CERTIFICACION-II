package gestion.parqueadero.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.parqueadero.app.web.models.entities.Uso;

public interface IUso extends CrudRepository<Uso, Integer>{

}
