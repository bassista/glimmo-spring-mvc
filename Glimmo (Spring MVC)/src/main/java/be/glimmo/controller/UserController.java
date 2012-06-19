package be.glimmo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.glimmo.dto.UserTransferObject;
import be.glimmo.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	
//	@RequestMapping(method=RequestMethod.POST, value="login")
//	public String login(Model model){
//		// TODO add security + login
//		return "home";
//	}
	
	@RequestMapping(method=RequestMethod.GET, value="register")
	public String launchRegistration(Model model){
		model.addAttribute("newUser", new UserTransferObject());
		return "registration";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{path}")
	public String processRegistration(Model model, @ModelAttribute(value="newUser")UserTransferObject user, @PathVariable String path){
		// TODO clean after test (testing user persistence)
		userService.createUser(user);
		model.addAttribute("loginUser", user);
		// END
		
		return "home";
	}
}
