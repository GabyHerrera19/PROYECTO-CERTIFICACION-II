package com.gestion.parqueadero.app.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity()
@Table(name = "TIPOINCIDENCIA")
public class TipoIncidencia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDTIPOINCIDENCIA")
	private Integer idtipoincidencia;
	
	@Column(name="TIPO")
	@Size(max=10)
	private String tipo;
	
	@Column(name="OBSERVACIONES")
	@Size(max=55)
	private String observaciones;
	
	@OneToMany(mappedBy= "tipoincidencia", fetch = FetchType.LAZY)//fetch
	private List<Uso> uso;
	
	public TipoIncidencia() {
		super();
	}
	
	public TipoIncidencia(Integer id) {
		super();
		this.idtipoincidencia = id;
	}

	public Integer getIdtipoincidencia() {
		return idtipoincidencia;
	}

	public void setIdtipoincidencia(Integer idtipoincidencia) {
		this.idtipoincidencia = idtipoincidencia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
