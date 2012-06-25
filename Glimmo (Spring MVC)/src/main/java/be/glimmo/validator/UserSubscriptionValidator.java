package be.glimmo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import be.glimmo.dto.UserTransferObject;
import be.glimmo.service.UserService;

@Component
public class UserSubscriptionValidator implements Validator {
	@Autowired
	private UserService userService;
	
	public boolean supports(Class<?> clazz) {
		return UserTransferObject.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserTransferObject targetUser = (UserTransferObject) target;
		
		if(!userService.checkUsernameAvailability(targetUser.getUsername())){
			errors.rejectValue("username", "username.unavailable", "This username is already taken");
		}
		
		if(!userService.checkEmailAvailability(targetUser.getEmail())){
			errors.rejectValue("email", "email.unavailable", "This email is already used in another account");
		}
		
		if(!targetUser.getPassword().equals(targetUser.getPasswordConfirmation())){
			errors.rejectValue("passwordConfirmation", "password.non.matching", "The password fields do not match");
		}
		
		
	}

}
