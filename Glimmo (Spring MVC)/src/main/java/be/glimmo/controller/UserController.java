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
import be.glimmo.validator.PasswordValidator;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordValidator passwordValidator;
	
	@RequestMapping(method=RequestMethod.GET, value="register")
	public String launchRegistration(Model model){
		model.addAttribute("newUser", new UserTransferObject());
		return "registration";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processRegistration(Model model, @ModelAttribute(value="newUser")
												   @Valid UserTransferObject user, 
												   BindingResult bindingResult){
		// executing a custom validator to check matching between the choosen password and the confirmed password
		passwordValidator.validate(user, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "registration";
		}
		
		// TODO clean after test (testing user persistence)
		userService.createUser(user);
		model.addAttribute("loginUser", user);
		// END
		
		return "home";
	}
}
