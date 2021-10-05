package com.fcfm.Tarea.models.dao;

import java.util.Date;
import java.util.List;

import com.fcfm.Tarea.models.entity.Prestamo;

public interface PrestamoDao {
	
	List<Prestamo> findAll();

	Prestamo find(Long id);

	void insert(Prestamo nuevo);

	void update(Prestamo nuevo);

	void delete(Long id);
	
    List<Prestamo> findIdC(Long id);
	
	List<Prestamo> findActivos();
	
	List<Prestamo> findPagados();

	List<Prestamo> findBFechas(Date startDate, Date endDate);


}
