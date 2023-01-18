package com.user.constraints.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.user.constraints.MerchantConstraint;
import com.user.entity.Merchant;
import com.user.enums.ErrorCodes;
import com.user.exception.GlobalException;

public class MerchantConstraintValidator implements ConstraintValidator<MerchantConstraint, Merchant>{

	@Override
	public boolean isValid(Merchant merchant, ConstraintValidatorContext context) {
		try {
			if(merchant.getEmail().isEmpty() || !merchant.getEmail().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,3}")) {
				throw new IllegalArgumentException();
			}
			else if(merchant.getUserFirstName().isEmpty()) {
				throw new NullPointerException();
			}
			else if(merchant.getUserLastName().isEmpty()) {
				throw new NullPointerException();
			}
			else if(merchant.getUserPassword().isEmpty()) {
				throw new NullPointerException();
			}
		}catch(Exception ex) {
			throw new GlobalException(ErrorCodes.PRODUCT_EXP_001);
		}
		return true;
	}
}
