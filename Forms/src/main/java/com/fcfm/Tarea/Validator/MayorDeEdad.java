package com.fcfm.Tarea.Validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = MayorDeEdadValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface MayorDeEdad {
	
	String message() default "Debes ser mayor de edad";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


}
