package com.fcfm.Tarea.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.fcfm.Tarea.models.entity.Cliente;

@Repository
public class ClienteDaoImp implements ClienteDao {

	@PersistenceContext
	private EntityManager en;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		List<Cliente> result = en.createQuery("from Cliente").getResultList();
		return result;
	}

	@Override
	public Cliente find(Long id) {
		Cliente result = en.find(Cliente.class, id);
		return result;
	}

	@Override
	@Transactional
	public void insert(Cliente nuevo) {
		if (nuevo.getId() != null && nuevo.getId() > 0) {
			en.merge(nuevo);
		} else {
			en.persist(nuevo);
		}
		en.flush();

	}

	@Override
	@Transactional
	public void update(Cliente nuevo) {
		Cliente antes = find(nuevo.getId());
		BeanUtils.copyProperties(nuevo, antes);
		en.flush();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Cliente entity = find(id);
		en.remove(entity);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findName(String name) {
		List<Cliente> lista = en.createQuery("from Cliente").getResultList();
		List<Cliente> result = new ArrayList<Cliente>();
		
		for (int i = 0; i < lista.size(); ++i) {
		    if(lista.get(i).getNombrecompleto().contains(name)) {
		    result.add(lista.get(i));
		    }
		}
		System.out.println(result);
		return result;
	}

	@Override
	@Transactional
	public void abonar(Cliente nuevo) {
		Cliente antes = find(nuevo.getId());
		antes.setMonto(antes.getMonto() + nuevo.getMonto());
	}

	@Override
	@Transactional
	public void retirar(Cliente nuevo) {
		Cliente antes = find(nuevo.getId());
		antes.setMonto(antes.getMonto() - nuevo.getMonto());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Float montoTotal() {
		List<Cliente> lista = en.createQuery("from Cliente").getResultList();
		float total = 0;
		
		for (int i = 0; i < lista.size(); ++i) {
		    total= total + lista.get(i).getMonto();
		}
		return total;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Cliente clienteMdinero() {
		List<Cliente> lista = en.createQuery("from Cliente").getResultList();
		float max=0;
		int flag = 0;
		
		for (int i = 0; i < lista.size(); ++i) {
		    if(max<lista.get(i).getMonto()) {
		    	max= lista.get(i).getMonto();
		    	flag=i;
		    }
		}
		
		return lista.get(flag);
	}

	
}
