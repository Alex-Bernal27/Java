package com.example.demo.web.dto;

public class MaestroRegistroDto {

	private String nombre;
	private int estatus;
	private String tipo;
	private String usuario;
	private String password;
	
	
	
	public MaestroRegistroDto() {
		
	}


	public MaestroRegistroDto(String nombre, int estatus, String tipo, String usuario, String password) {
		super();
		this.nombre = nombre;
		this.estatus = estatus;
		this.tipo = tipo;
		this.usuario = usuario;
		this.password = password;
	}




	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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
		this.estatus = estatus;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
