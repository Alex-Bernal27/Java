package com.example.demo.models.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long matricula;
	
	private String nombre;
	private Float estatus;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
	 private Role rol;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "grupos_alumno", 
			joinColumns = @JoinColumn(
					name = "alumno_id", referencedColumnName = "matricula"),
			inverseJoinColumns = @JoinColumn(
					name = "grupo_id", referencedColumnName = "id") )
	private Collection<Grupo> materias;
	
	
	
	public Alumno() {
		super();
	}
	
	public Alumno(String nombre, Float estatus, Role rol, Collection<Grupo> materias) {
		super();
		this.nombre = nombre;
		this.estatus = estatus;
		this.rol = rol;
		this.materias = materias;
	}

	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
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
	public void setEstatus(int estatus) {
		this.estatus = (float) estatus;
	}
	public Collection<Grupo> getMaterias() {
		return materias;
	}
	public void setMaterias(Collection<Grupo> materias) {
		this.materias = materias;
	}
	
	public void setEstatus(Float estatus) {
		this.estatus = estatus;
	}

	public Role getRol() {
		return rol;
	}

	public void setRol(Role rol) {
		this.rol = rol;
	}

	
	
	
}
