package be.glimmo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value="HomeController")
public class HomeController {
	
	@RequestMapping(method=GET)
	public String directToHomepage(Model model){
		// TODO retrieve list of goods to display and stuff them into the model object
		
		return "home";
	}
}
