package com.fcfm.Tarea.models.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fcfm.Tarea.models.entity.Cliente;
import com.fcfm.Tarea.models.entity.Prestamo;

@Repository
public class PrestamoDaoImp implements PrestamoDao {
	
	@PersistenceContext
	private EntityManager en;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> findAll() {
		List<Prestamo> result = en.createQuery("from Prestamo").getResultList();
		return result;
	}
	
	@Override
	public Prestamo find(Long id) {
		Prestamo result = en.find(Prestamo.class, id);
		return result;
	}
	

	@Override
	@Transactional
	public void insert(Prestamo nuevo) {
		if (nuevo.getCliente_id() != null) {
			en.merge(nuevo);
		} else {
			en.persist(nuevo);
		}
		en.flush();
	}

	@Override
	@Transactional
	public void update(Prestamo nuevo) {
		Prestamo antes = find(nuevo.getId());
		antes.setAbonototal(antes.getAbonototal()+nuevo.getAbonototal());
		if(antes.getAbonototal() >= antes.getMonto()) {
			antes.setPagado(true);
		}
		en.flush();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Prestamo entity = find(id);
		en.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> findIdC(Long id) {
		List<Prestamo> lista = en.createQuery("from Prestamo").getResultList();
		List<Prestamo> result = new ArrayList<Prestamo>();
		
		for (int i = 0; i < lista.size(); ++i) {
		    if(lista.get(i).getCliente_id().getId()==id) {
		    result.add(lista.get(i));
		    }
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> findActivos() {
		List<Prestamo> lista = en.createQuery("from Prestamo").getResultList();
		List<Prestamo> result = new ArrayList<Prestamo>();
		
		for (int i = 0; i < lista.size(); ++i) {
		    if(lista.get(i).getPagado()==false) {
		    result.add(lista.get(i));
		    }
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> findPagados() {
		List<Prestamo> lista = en.createQuery("from Prestamo").getResultList();
		List<Prestamo> result = new ArrayList<Prestamo>();
		
		for (int i = 0; i < lista.size(); ++i) {
		    if(lista.get(i).getPagado()==true) {
		    result.add(lista.get(i));
		    }
		}
		
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Prestamo> findBFechas(Date startDate, Date endDate) {
		List<Prestamo> lista = en.createQuery("from Prestamo").getResultList();
		List<Date> datesInRange = new ArrayList<>();
		List<Prestamo> resultado = new ArrayList<Prestamo>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		
		Calendar endCalendar = new GregorianCalendar();
		endCalendar.setTime(endDate);
		
		while (calendar.before(endCalendar)) {
			Date result = calendar.getTime();
			datesInRange.add(result);
			calendar.add(Calendar.DATE, 1);
			}
		
		for (int i = 0; i < lista.size(); ++i) {
		    if(datesInRange.contains(lista.get(i).getFechacreacion())) {
		    resultado.add(lista.get(i));
		    }
		}	
		
		return resultado;
	}


}
