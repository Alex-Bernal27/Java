package com.fcfm.Tarea.models.dao;

import java.util.List;

import com.fcfm.Tarea.models.entity.Cliente;

public interface ClienteDao {

	List<Cliente> findAll();

	Cliente find(Long id);
	
	List<Cliente> findName(String name);
	
	Float montoTotal();
	
	Cliente clienteMdinero();

	void insert(Cliente nuevo);

	void update(Cliente nuevo);
	
	void abonar(Cliente nuevo);
	
	void retirar(Cliente nuevo);

	void delete(Long id);

}
