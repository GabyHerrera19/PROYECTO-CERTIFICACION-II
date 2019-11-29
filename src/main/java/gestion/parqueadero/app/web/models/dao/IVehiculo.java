package gestion.parqueadero.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.gestion.parqueadero.app.web.models.entities.Vehiculo;

public interface IVehiculo extends CrudRepository<Vehiculo, Integer>{

}
