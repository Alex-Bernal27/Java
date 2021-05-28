package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.MaestroService;
import com.example.demo.service.UserService;
import com.example.demo.web.dto.MaestroRegistroDto;
import com.example.demo.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registroMaestro")
public class MaestroRegistrationController {
	
	private MaestroService maestroService;
	
	private UserService userService;
	
	
	
	public MaestroRegistrationController(MaestroService maestroService, UserService userService) {
		super();
		this.maestroService = maestroService;
		this.userService = userService;
	}

	@ModelAttribute("maestro")
	public MaestroRegistroDto maestroRegistroDto() {
		return new MaestroRegistroDto();
	}
	
	@PostMapping
	public String registroMaestro(@ModelAttribute("maestro") MaestroRegistroDto registrationDto) {
		UserRegistrationDto userDto = new UserRegistrationDto(registrationDto.getUsuario(),registrationDto.getPassword());
		
		maestroService.save(registrationDto);
		userService.saveMaestro(userDto);
		return "redirect:/registroMaestro?success";
	}
	
	@GetMapping
	public String mostrarFormRegistro() {
		return "registroMaestro";
	}
	
	/*
	@GetMapping
	public String mostrarFormRegistro(Model model) {
		model.addAttribute("maestro", new MaestroRegistroDto());
		return "registroMaestro";
	}
	*/

}
