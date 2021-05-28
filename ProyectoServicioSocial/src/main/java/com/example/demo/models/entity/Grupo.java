package com.example.demo.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grupo")
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "materia_id", referencedColumnName = "clave")
	private Materia claveMat;
	
	
	private Float cantAlumnos;
	private Float estatus;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Materia getClaveMat() {
		return claveMat;
	}
	public void setClaveMat(Materia claveMat) {
		this.claveMat = claveMat;
	}
	public Float getCantAlumnos() {
		return cantAlumnos;
	}
	public void setCantAlumnos(Float cantAlumnos) {
		this.cantAlumnos = cantAlumnos;
	}
	public Float getEstatus() {
		return estatus;
	}
	public void setEstatus(Float estatus) {
		this.estatus = estatus;
	}
	
}
