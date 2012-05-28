package be.glimmo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import be.glimmo.domain.Advertisement;
import be.glimmo.service.AdvertisementService;

@Controller(value="HomeController")
public class HomeController {
	@Autowired
	AdvertisementService advertisementService;
	
	@RequestMapping(method=GET)
	public String directToHomepage(Model model){
		// TODO retrieve list of goods to display and stuff them into the model object
		
		List<Advertisement> list = advertisementService.listAllAdvertisements();
		return "home";
	}
}
