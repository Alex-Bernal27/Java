package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MaestroService;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.MaestroRegistroDto;
import com.example.demo.web.dto.UserRegistrationDto;

@Controller
public class MainController {
	
	private MaestroService maestroService;
	
	private UserService userService;

	public MainController(MaestroService maestroService, UserService userService) {
		super();
		this.maestroService = maestroService;
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login() {
		userService.saveMaestro( new UserRegistrationDto("adriana","hola"));
		//maestroService.save(new MaestroRegistroDto("Adriana",1,"Matematicas","adr"));
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
}
