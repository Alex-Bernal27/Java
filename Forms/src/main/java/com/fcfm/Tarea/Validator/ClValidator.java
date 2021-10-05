package com.fcfm.Tarea.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.fcfm.Tarea.models.entity.Cliente;

public class ClValidator implements ConstraintValidator<Cl, Cliente>{

	@Override
	public boolean isValid(Cliente cliente, ConstraintValidatorContext context) {
		if(cliente.getId()!=null) {
			return true;
		}
		return false;
	}
}
