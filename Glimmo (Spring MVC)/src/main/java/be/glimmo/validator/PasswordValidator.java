package be.glimmo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import be.glimmo.dto.UserTransferObject;

@Component
public class PasswordValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return UserTransferObject.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserTransferObject targetUser = (UserTransferObject) target;
		
		if(!targetUser.getPassword().equals(targetUser.getPasswordConfirmation())){
			errors.rejectValue("passwordConfirmation", "password.non.matching", "The password fields do not match");
		}
	}

}
