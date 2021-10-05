package com.fcfm.Tarea.Validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ClUnicoValidator.class)
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD, ANNOTATION_TYPE })
public @interface ClUnico {
	String message() default "Este cliente ya cuenta con un prestamo. El limite de prestamos por cliente es de 1";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
