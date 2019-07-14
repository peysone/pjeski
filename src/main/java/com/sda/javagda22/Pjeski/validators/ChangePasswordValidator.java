package com.sda.javagda22.Pjeski.validators;


import com.sda.javagda22.Pjeski.constants.PjeskiConstants;
import com.sda.javagda22.Pjeski.domain.model.User;
import com.sda.javagda22.Pjeski.utilities.PjeskiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class ChangePasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		@SuppressWarnings("unused")
		User u = (User) obj;
		
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "error.userPassword.empty");
		
	}
	
	public void checkPasswords(String newPass, Errors errors) {
		
		if (!newPass.equals(null)) {
			boolean isMatch = PjeskiUtils.checkEmailOrPassword(PjeskiConstants.PASSWORD_PATTERN, newPass);
			if(!isMatch) {
				errors.rejectValue("newPassword", "error.userPasswordIsNotMatch");
			}
		}
	}
}
