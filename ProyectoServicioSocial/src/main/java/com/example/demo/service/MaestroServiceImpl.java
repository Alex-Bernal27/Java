package com.example.demo.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo.models.entity.Maestro;
import com.example.demo.models.entity.Role;
import com.example.demo.repository.MaestroRepository;
import com.example.demo.web.dto.MaestroRegistroDto;

@Service
public class MaestroServiceImpl implements MaestroService{

	private MaestroRepository maestroRepository;
	
	
	

	public MaestroServiceImpl(MaestroRepository maestroRepository) {
		super();
		this.maestroRepository = maestroRepository;
	}




	@Override
	public Maestro save(MaestroRegistroDto registrationDto) {
		Maestro maestro = new Maestro( registrationDto.getNombre(), 1, registrationDto.getTipo(), new Role("MAESTRO"));
		
		return maestroRepository.save(maestro);
	}

}
