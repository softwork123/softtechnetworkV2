package com.netw.softtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

	@GetMapping(value="/")
	public String home() {
		return "views/home";
	}
	
	@GetMapping(value="/aboutus")
	public String aboutus() {
		return "views/aboutus";
	}
	@GetMapping(value="/contactus")
	public String contactus() {
		return "views/contactus";
	}
}
