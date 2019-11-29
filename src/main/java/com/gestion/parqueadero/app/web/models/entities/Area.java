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
@Table(name = "AREA")
public class Area implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDAREA")
	private Integer idarea;
	
	@Column(name="NOMBRE_AREA")
	@Size(max=10)
	private String nombrearea;
	
	@Column(name="CODIGO")
	@Size(max=10)
	private String codigo;
	
	@OneToMany(mappedBy= "area", fetch = FetchType.LAZY)//fetch
	private List<Estacionamiento> estacionamiento;
	
	public Area() {
		super();
	}
	
	public Area(Integer id) {
		super();
		this.idarea = id;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public String getNombrearea() {
		return nombrearea;
	}

	public void setNombrearea(String nombrearea) {
		this.nombrearea = nombrearea;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Estacionamiento> getEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(List<Estacionamiento> estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
