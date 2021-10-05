package com.fcfm.Tarea.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Tipo123Validator implements ConstraintValidator<Tipo123,Integer>{

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value!=null) {
			if(value >= 1 && value<=3) return true;
		}
		return false;
	}
	
	

}
