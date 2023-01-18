package com.user.constraints.validators;

import com.user.constraints.ProductConstraint;
import com.user.enums.ErrorCodes;
import com.user.exception.GlobalException;
import com.user.output.SaveProductResponse;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductConstraintValidator implements ConstraintValidator<ProductConstraint, SaveProductResponse>{
	
	@Override
	public boolean isValid(SaveProductResponse saveProductResponse, ConstraintValidatorContext context) {
		try{
			if(saveProductResponse.getPrice()<=0) {
				throw new IllegalArgumentException();
			}
			else if(saveProductResponse.getDescription().isEmpty()) {
				throw new NullPointerException();
			}
			else if(saveProductResponse.getName().isEmpty()) {
				throw new NullPointerException();
			}
		}
		catch(Exception ex) {
			throw new GlobalException(ErrorCodes.PRODUCT_EXP_001);
		}
		return true;
	}
}
