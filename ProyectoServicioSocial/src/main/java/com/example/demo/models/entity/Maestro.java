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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "maestro")
public class Maestro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long NumEmp;
	
	@NotEmpty
	private String nombre;
	
	@NotNull
	private int estatus;
	
	@NotEmpty
	private String tipo;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role rol;
	
	public Maestro() {
		super();
	}
	

	public Maestro(@NotEmpty String nombre, @NotNull int estatus, @NotEmpty String tipo, Role rol) {
		super();
		this.nombre = nombre;
		this.estatus = estatus;
		this.tipo = tipo;
		this.rol = rol;
	}



	public Long getNumEmp() {
		return NumEmp;
	}
	public void setNumEmp(Long numEmp) {
		NumEmp = numEmp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus =  estatus;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Role getRol() {
		return rol;
	}
	public void setRol(Role rol) {
		this.rol = rol;
	}

	
	
}
