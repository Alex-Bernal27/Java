package com.fcfm.Tarea.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fcfm.Tarea.models.entity.Maestro;

@Repository
public class MaestroDaoImp implements MaestroDao {

	@PersistenceContext
	private EntityManager en;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Maestro> findAll() {
		List<Maestro> result = en.createQuery("from Maestro").getResultList();
		return result;
	}

	@Override
	@Transactional(readOnly = true)
	public Maestro find(Long id) {
		Maestro  result = en.find(Maestro.class, id);
		return result;
	}

	@Override
	@Transactional
	public void insert(Maestro nuevo) {
		if(nuevo.getId() != null && nuevo.getId() > 0) {
			en.merge(nuevo);
		}else {
			en.persist(nuevo);}
		en.flush();

	}

	@Override
	@Transactional
	public void update(Maestro nuevo) {
		Maestro antes = find(nuevo.getId());
		BeanUtils.copyProperties(nuevo, antes);
		en.flush();
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Maestro entity = find(id);
		en.remove(entity);

	}

}
