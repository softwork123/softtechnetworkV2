package com.netw.softtech.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.netw.softtech.model.User;
import com.netw.softtech.services.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String registerationForm(Model model) {
		model.addAttribute("user", new User());
		return "views/registerationForm";
	}
	
	@PostMapping("/register")
	public String registerationForm(@Valid User user,BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
		return "views/registerationForm";
		}
		if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exist", true);
			return "views/registerationForm";
		}
		userService.createUser(user);
		return "views/success";
	}

}
