package com.example.demo.web.dto;

public class UserRegistrationDto {

	private String usuario;
	
	private String password;

	public UserRegistrationDto(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public UserRegistrationDto() {
		super();
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
	
	
}
