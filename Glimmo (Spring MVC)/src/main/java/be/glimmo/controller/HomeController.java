package be.glimmo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(method=GET, value={"/", "/home"})
	public String test(HttpSession session){
		System.out.println("Working on branch");
		return "home";
	}
}
