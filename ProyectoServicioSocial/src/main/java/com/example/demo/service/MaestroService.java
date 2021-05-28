package com.example.demo.service;


import com.example.demo.models.entity.Maestro;
import com.example.demo.web.dto.MaestroRegistroDto;

public interface MaestroService {

	Maestro save(MaestroRegistroDto registrationDto);
}
