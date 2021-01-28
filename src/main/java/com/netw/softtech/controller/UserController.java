package com.netw.softtech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netw.softtech.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public String listUsers(Model model,@RequestParam(defaultValue = "") String name) {
		model.addAttribute("users", userService.findAll());
		return "views/list";
	}

	@GetMapping("/usersbywords")
	public String listUsersByWords(Model model,@RequestParam(defaultValue = "") String name) {
		model.addAttribute("users", userService.findByName(name));
		return "views/list";
	}
}
