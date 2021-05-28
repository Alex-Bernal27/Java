package com.example.demo.models.entity;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipo;
	
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinColumn(name = "maestro_rol", referencedColumnName = "NumEmp")
	 private Set<Maestro> maestros;
	 
	// @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   //  @JoinColumn(name = "alumno_rol", referencedColumnName = "matricula")
	// private Alumno alumno;
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinColumn(name = "alumno_rol", referencedColumnName = "matricula")
	 private Set<Alumno> alumnos;
	 
	 @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinColumn(name = "admin_rol", referencedColumnName = "id")
	 private Set<Administrador> admins;


	

	public Role(String tipo, Set<Maestro> maestros, Set<Alumno> alumnos, Set<Administrador> admins) {
		super();
		this.tipo = tipo;
		this.maestros = maestros;
		this.alumnos = alumnos;
		this.admins = admins;
	}

	public Role(String tipo) {
		super();
		this.tipo = tipo;
	}

	public Role() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Maestro> getMaestros() {
		return maestros;
	}

	public void setMaestros(Set<Maestro> maestros) {
		this.maestros = maestros;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Set<Administrador> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<Administrador> admins) {
		this.admins = admins;
	}


	
	
}
