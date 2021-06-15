package com.fcfm.Tarea.models.dao;

import java.util.List;

import com.fcfm.Tarea.models.entity.Animal;

public interface AnimalDao {

	List<Animal> findAll();

	Animal find(Long id);

	void insert(Animal nuevo);

	void update(Animal nuevo);

	void delete(Long id);

}
