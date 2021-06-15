package com.fcfm.Tarea.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fcfm.Tarea.models.dao.MaestroDao;
import com.fcfm.Tarea.models.entity.Maestro;

@Controller
@RequestMapping(path = "/maestro")
@SessionAttributes("maestro")
public class MaestroController {
	
	@Autowired
	private MaestroDao maestroDao;

	@GetMapping({ "", "/" })
	public String alumnos(Model model) {
		model.addAttribute("titulo", "Maestro");
		model.addAttribute("maestros", maestroDao.findAll());
		return "catalogo/maestro/lista";
	}
	
	@GetMapping({ "/form" })
	public String form(Model model) {
		model.addAttribute("titulo", "Maestro");
		Maestro nuevo = new Maestro();
		model.addAttribute("maestro", nuevo);
		return "catalogo/maestro/form";
	}
	
	
	
	@GetMapping({ "/form/{id}" })
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Maestro");
		Maestro editar = maestroDao.find(id);
		model.addAttribute("maestro", editar);
		return "catalogo/maestro/form";
	}

	
	@PostMapping({ "/guardar" })
	public String guardar(@Valid Maestro maestro, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Maestro");
			return "catalogo/maestro/form";
		}
		
	
		if (maestro.getId() != null && maestro.getId() > 0) {
			maestroDao.update(maestro);
		} else {
			maestroDao.insert(maestro);
		}

		sesion.setComplete();
		return "redirect:/maestro";
	}
	
	
	
	@GetMapping({ "/eliminar/{id}" })
	public String eliminar(@PathVariable Long id, Model model) {
		if (id != null && id > 0) {
			maestroDao.delete(id);
		}
		return "redirect:/maestro";
	}
	
	
}
