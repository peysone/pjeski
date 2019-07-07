package com.sda.javagda22.Pjeski.validators;

import com.sda.javagda22.Pjeski.constants.PjeskiConstants;
import com.sda.javagda22.Pjeski.domain.model.User;
import com.sda.javagda22.Pjeski.utilities.PjeskiUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserRegisterValidator implements Validator {
    @Override
    public boolean supports(Class<?> cls) {
        return User.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;

        ValidationUtils.rejectIfEmpty(errors, "firstName", "error.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");

        if (!user.getEmail().equals(null)) {
            boolean isMatch = PjeskiUtils.checkEmailOrPassword(PjeskiConstants.EMAIL_PATTERN, user.getEmail());
            if(!isMatch) {
                errors.rejectValue("email", "error.userEmailIsNotMatch");
            }
        }

        if (!user.getPassword().equals(null)) {
            boolean isMatch = PjeskiUtils.checkEmailOrPassword(PjeskiConstants.PASSWORD_PATTERN, user.getPassword());
            if(!isMatch) {
                errors.rejectValue("password", "error.userPasswordIsNotMatch");
            }
        }

    }

    public void validateEmailExist(User user, Errors errors) {
        if (user != null) {
            errors.rejectValue("email", "error.userEmailExist");
        }
    }

}
