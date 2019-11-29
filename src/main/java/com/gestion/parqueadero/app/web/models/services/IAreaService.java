package com.gestion.parqueadero.app.web.models.services;

import java.util.List;
import com.gestion.parqueadero.app.web.models.entities.Area;

public interface IAreaService {
	
			//Este metodo crea un nuevo registro de TipoEnfermedad
			//o actualiza un registro anterior
			public void save (Area area);
			
			public Area findById(Integer id);
			
			public void delete(Integer id);
			
			public List<Area> findAll();

}
