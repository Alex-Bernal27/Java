package com.fcfm.Tarea.Validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = Tipo123Validator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface Tipo123 {
	
	String message() default "Debes ser tipo 1,2 o 3";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


}
