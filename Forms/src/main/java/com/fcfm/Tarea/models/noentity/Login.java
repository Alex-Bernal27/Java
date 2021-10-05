package com.fcfm.Tarea.models.noentity;

import javax.validation.constraints.NotEmpty;

public class Login {

	@NotEmpty
	private String user;

	@NotEmpty
	private String pass;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
