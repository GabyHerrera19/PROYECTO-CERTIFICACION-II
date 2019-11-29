package com.gestion.parqueadero.app.web.models.services;

import java.util.List;
import com.gestion.parqueadero.app.web.models.entities.TipoIncidencia;

public interface ITipoIncidenciaService {
	
		//Este metodo crea un nuevo registro de TipoEnfermedad
		//o actualiza un registro anterior
		public void save (TipoIncidencia tipoIncidencia);
		
		public TipoIncidencia findById(Integer id);
		
		public void delete(Integer id);
		
		public List<TipoIncidencia> findAll();

}
