package com.gestion.parqueadero.app.web.models.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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

import com.gestion.parqueadero.app.web.models.entities.TipoIncidencia;
import com.gestion.parqueadero.app.web.models.entities.Vehiculo;

@Entity()
@Table(name = "USO")
public class Uso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDUSO")
	private Integer iduso;
	
	@Column(name="HORAENTRADA")
	@Size(max=10)
	private Time hora_entrada;
	
	@Column(name="HORASALIDA")
	@Size(max=10)
	private Time hora_salida;
	
	@Column(name="TIEMPO")
	@Size(max=2)
	private Integer tiempo;
	
	@Column(name="COSTO")
	@Size(max=5)
	private Float costo;
	
	@Column(name="FECHA")
	@Size(max=10)
	private Date fecha;
	
	@Column(name="INCIDENCIA")
	@Size(max=10)
	private String incidencia;
	
	@Column(name="OBSERVACIONES")
	@Size(max=55)
	private String observaciones;
	
	@JoinColumn(name= "IDVEHICULO", referencedColumnName = "IDVEHICULO")
	@ManyToOne
	private Vehiculo vehiculo;
	
	@JoinColumn(name= "IDTIPOINCIDENCIA", referencedColumnName = "IDTIPOINCIDENCIA")
	@ManyToOne
	private TipoIncidencia tipoincidencia;
		
	public Uso() {
		super();
	}
	
	public Uso(Integer id) {
		super();
		this.iduso = id;
	}

	public Integer getIduso() {
		return iduso;
	}

	public void setIduso(Integer iduso) {
		this.iduso = iduso;
	}

	public Time getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(Time hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public Time getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(Time hora_salida) {
		this.hora_salida = hora_salida;
	}

	public Integer getTiempo() {
		return tiempo;
	}

	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}

	public Float getCosto() {
		return costo;
	}

	public void setCosto(Float costo) {
		this.costo = costo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String incidencia) {
		this.incidencia = incidencia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
