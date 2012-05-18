package be.glimmo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value="HomeController")
public class HomeController {
	
	@RequestMapping(method=GET)
	public String directToHomepage(){
		return "home";
	}
}
