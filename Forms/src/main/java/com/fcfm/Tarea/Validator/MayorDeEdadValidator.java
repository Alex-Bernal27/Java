package com.fcfm.Tarea.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MayorDeEdadValidator implements ConstraintValidator<MayorDeEdad,Integer>{

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value != null) {
			return value>=18;
		}
		return false;
	}
	
	

}
