package com.example.demo.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clave;
	
	private String nombre;
	private Float estatus;
	
	public Long getClave() {
		return clave;
	}
	public void setClave(Long clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getEstatus() {
		return estatus;
	}
	public void setEstatus(Float estatus) {
		this.estatus = estatus;
	}
}
