package be.glimmo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import be.glimmo.dto.UserTransferObject;
import be.glimmo.service.UserService;

@Controller(value="HomeController")
public class HomeController {
	@Autowired
	UserService userService;
	
	// Mapping to URI value "index" as well to handle homepage
	@RequestMapping(method=GET, value={"index", "home"})
	public String directToHomepage(Model model){
		model.addAttribute("loginUser", new UserTransferObject());
		
		return "home";
	}
	
	@RequestMapping(value="home", params="errorLogin")
	public String directToHomepageWithLoginError(Model model){
		// Adding an attribute to flag that an error happened at login
		model.addAttribute("errorOccurred", true);
		
		return "home";
	}
	
}
