package com.user.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.jvnet.staxex.StAxSOAPBody.Payload;

import com.user.constraints.validators.ProductConstraintValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD , ElementType.PARAMETER})
@Constraint(validatedBy=ProductConstraintValidator.class)
@Documented
public @interface ProductConstraint {
	
	String message() default "INVALID PRODUCT REQUEST";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
