package com.fcfm.Tarea.Validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fcfm.Tarea.models.dao.PrestamoDao;
import com.fcfm.Tarea.models.dao.PrestamoDaoImp;
import com.fcfm.Tarea.models.entity.Cliente;
import com.fcfm.Tarea.models.entity.Prestamo;

public class ClUnicoValidator implements ConstraintValidator<ClUnico, Prestamo>{
	
	@Override
	public boolean isValid(Prestamo prestamo, ConstraintValidatorContext context) {
		PrestamoDaoImp prestamoDao= new PrestamoDaoImp();
		if(prestamo!=null) {
			System.out.println("entre");
			Cliente cliente = prestamo.getCliente_id();
			System.out.println(cliente.getId());
			List<Prestamo> prestamos = prestamoDao.findAll();
			
			if(cliente.getId()!=null) {
				for(Prestamo p: prestamos) {
					if(p.getCliente_id().getId()==cliente.getId() && prestamo.getAbonototal()<0) {
						System.out.println("entre al if");
						return false;
					}else {
						System.out.println("entra al ese");
						return true;
					}
				}
			}
		}
		return true;
	}
}