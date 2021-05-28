package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.models.entity.User;
import com.example.demo.web.dto.MaestroRegistroDto;
import com.example.demo.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User saveAdmin(UserRegistrationDto registrationDto);
	User saveMaestro(UserRegistrationDto registrationDto);
	User saveAlumno(UserRegistrationDto registrationDto);
}
