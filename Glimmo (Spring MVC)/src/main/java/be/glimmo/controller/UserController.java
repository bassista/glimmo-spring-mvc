package be.glimmo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.glimmo.dto.UserTransferObject;
import be.glimmo.service.UserService;
import be.glimmo.validator.UserSubscriptionValidator;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	UserSubscriptionValidator passwordValidator;
	
	@RequestMapping(method=RequestMethod.GET, value="register")
	public String launchRegistration(Model model){
		model.addAttribute("newUser", new UserTransferObject());
		return "registration";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="register")
	public String processRegistration(Model model, @ModelAttribute(value="newUser")
												   @Valid UserTransferObject user, 
												   BindingResult bindingResult){
		// executing a custom validator to check matching between the choosen password and the confirmed password
		passwordValidator.validate(user, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "registration";
		}
		
		userService.createUser(user);
		return "home";
	}
}
