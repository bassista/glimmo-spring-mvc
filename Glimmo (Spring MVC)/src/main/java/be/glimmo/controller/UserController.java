package be.glimmo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.glimmo.domain.User;
import be.glimmo.dto.UserTransferObject;

@Controller
public class UserController {
	
	@RequestMapping(method=RequestMethod.POST, value="login")
	public String login(Model model){
		// TODO add security + login
		return "home";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="register")
	public String register(Model model){
		model.addAttribute("newUser", new UserTransferObject());
		return "registration";
	}
}
