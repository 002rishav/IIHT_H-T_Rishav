package com.user.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import org.jvnet.staxex.StAxSOAPBody.Payload;

import com.user.constraints.validators.MerchantConstraintValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD , ElementType.PARAMETER})
@Constraint(validatedBy=MerchantConstraintValidator.class)
@Documented
public @interface MerchantConstraint {
	
	String message() default "INVALID MERCHANT REQUEST";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}