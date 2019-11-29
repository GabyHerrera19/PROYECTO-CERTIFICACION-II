package com.gestion.parqueadero.app.web.models.entities;

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

import com.gestion.parqueadero.app.web.models.entities.Vehiculo;

@Entity()
@Table(name = "PROPIETARIO")
public class Propietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDPROPIETARIO")
	private Integer idpropietario;
	
	@Column(name="CEDULA")
	@Size(max=10)
	private String cedula;
	
	@Column(name="NOMBRE")
	@Size(max=55)
	private String nombre;
	
	@Column(name="APELLIDO")
	@Size(max=55)
	private String apellido;
	
	@OneToMany(mappedBy= "propietario", fetch = FetchType.LAZY)//fetch
	private List<Vehiculo> vehiculo;
	
	public Propietario() {
		super();
	}
	
	public Propietario(Integer id) {
		super();
		this.idpropietario = id;
	}	

	public Integer getIdpropietario() {
		return idpropietario;
	}

	public void setIdpropietario(Integer idpropietario) {
		this.idpropietario = idpropietario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public List<Vehiculo> getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(List<Vehiculo> vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
