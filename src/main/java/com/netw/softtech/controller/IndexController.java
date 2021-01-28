package com.netw.softtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public String showIndexPage() {
		return "index";
	}

	@GetMapping("/login")
	public String showLoginForm(){
		return "views/loginForm";
	}
}
