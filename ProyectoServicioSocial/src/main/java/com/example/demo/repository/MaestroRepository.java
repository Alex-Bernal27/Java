package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.entity.Maestro;

@Repository
public interface MaestroRepository extends JpaRepository<Maestro,Long>{

	Maestro findByNombre(String nombre);
}
