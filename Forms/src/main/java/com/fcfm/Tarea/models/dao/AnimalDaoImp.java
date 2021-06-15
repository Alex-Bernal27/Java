package com.fcfm.Tarea.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.fcfm.Tarea.models.entity.Animal;

@Repository
public class AnimalDaoImp implements AnimalDao {

	@PersistenceContext
	private EntityManager en;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Animal> findAll() {
		List<Animal> result = en.createQuery("from Animal").getResultList();
		return result;
	}

	@Override
	public Animal find(Long id) {
		Animal result = en.find(Animal.class, id);
		return result;
	}

	@Override
	@Transactional
	public void insert(Animal nuevo) {
		if (nuevo.getId() != null && nuevo.getId() > 0) {
			en.merge(nuevo);
		} else {
			en.persist(nuevo);
		}
		en.flush();

	}

	@Override
	@Transactional
	public void update(Animal nuevo) {
		Animal antes = find(nuevo.getId());
		BeanUtils.copyProperties(nuevo, antes);
		en.flush();

	}

	@Override
	@Transactional
	public void delete(Long id) {
		Animal entity = find(id);
		en.remove(entity);

	}

}
