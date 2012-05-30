package be.glimmo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import be.glimmo.domain.Advertisement;
import be.glimmo.service.AdvertisementService;
import be.glimmo.service.UserService;

@Controller(value="HomeController")
public class HomeController {
	@Autowired
	AdvertisementService advertisementService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method=GET)
	public String directToHomepage(Model model){
		// TODO retrieve list of goods to display and stuff them into the model object
		
//		List<Advertisement> list = advertisementService.listAllAdvertisements();
		
		// TODO clean after test
		String dummyUsername = RandomStringUtils.randomAlphabetic(10);
		userService.createUser(dummyUsername, dummyUsername + "@gmail.com", "firstname", "lastname", "secr3t");
		// END
		return "home";
	}
}
