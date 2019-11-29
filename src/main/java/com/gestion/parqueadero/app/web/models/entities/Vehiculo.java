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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.gestion.parqueadero.app.web.models.entities.Propietario;

@Entity
@Table(name = "VEHICULO")//mapear
public class Vehiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDVEHICULO")	
	private Integer idvehiculo;
	
	@Column(name="PLACA")
	@Size(max=6)
	private String placa;
	
	@Column(name="COLOR")
	@Size(max=10)
	private String color;
	
	@JoinColumn(name= "IDPROPIETARIO", referencedColumnName = "IDPROPIETARIO")
	@ManyToOne
	private Propietario propietario;
	
	@OneToMany(mappedBy= "vehiculo", fetch = FetchType.LAZY)//fetch
	private List<Uso> uso;
	
	@OneToMany(mappedBy= "vehiculo", fetch = FetchType.LAZY)//fetch
	private List<Estacionamiento> estacionamiento;
	
	public Vehiculo() {
		super();
	}
	
	public Vehiculo(Integer id) {
		super();
		this.idvehiculo = id;
	}

	
	public Integer getIdvehiculo() {
		return idvehiculo;
	}

	public void setIdvehiculo(Integer idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
