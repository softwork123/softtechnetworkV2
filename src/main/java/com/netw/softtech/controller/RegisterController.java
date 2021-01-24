package com.netw.softtech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.netw.softtech.model.User;

@Controller
public class RegisterController {
	
	@GetMapping("/register")
	public String registerationForm(Model model) {
		model.addAttribute("user", new User());
		return "views/registerationForm";
	}
	
	

}
