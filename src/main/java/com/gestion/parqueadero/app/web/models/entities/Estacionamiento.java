package com.gestion.parqueadero.app.web.models.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.gestion.parqueadero.app.web.models.entities.Vehiculo;
import com.gestion.parqueadero.app.web.models.entities.Area;

@Entity()
@Table(name = "ESTACIONAMIENTO")
public class Estacionamiento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDESTACIONAMIENTO")
	private Integer idestacionamiento;
	
	@Column(name="NUMERO")
	@Size(max=10)
	private String numero;
	
	@Column(name="ESTADO")
	@Size(max=10)
	private String estado;
	
	@JoinColumn(name= "IDVEHICULO", referencedColumnName = "IDVEHICULO")
	@ManyToOne
	private Vehiculo vehiculo;
	
	@JoinColumn(name= "IDAREA", referencedColumnName = "IDAREA")
	@ManyToOne
	private Area area;
	
	public Estacionamiento() {
		super();
	}
	
	public Estacionamiento(Integer id) {
		super();
		this.idestacionamiento = id;
	}

	

	public Integer getIdestacionamiento() {
		return idestacionamiento;
	}

	public void setIdestacionamiento(Integer idestacionamiento) {
		this.idestacionamiento = idestacionamiento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
}
