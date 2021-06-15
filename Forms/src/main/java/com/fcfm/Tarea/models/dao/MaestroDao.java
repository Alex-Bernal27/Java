package com.fcfm.Tarea.models.dao;

import java.util.List;

import com.fcfm.Tarea.models.entity.Maestro;

public interface MaestroDao {

	List<Maestro> findAll();

	Maestro find(Long id);

	void insert(Maestro nuevo);

	void update(Maestro nuevo);

	void delete(Long id);
}
