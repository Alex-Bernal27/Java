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

import com.fcfm.Tarea.models.dao.AnimalDao;
import com.fcfm.Tarea.models.entity.Animal;

@Controller
@RequestMapping(path = "/animal")
@SessionAttributes("animal")
public class AnimalController {

	@Autowired
	private AnimalDao animalDao;

	@GetMapping({ "", "/" })
	public String animales(Model model) {
		model.addAttribute("titulo", "Animales");
		model.addAttribute("animales", animalDao.findAll());
		return "catalagoanimal/animal/lista";
	}

	@GetMapping({ "/form" })
	public String form(Model model) {
		model.addAttribute("titulo", "Animal");
		Animal nuevo = new Animal();
		model.addAttribute("animal", nuevo);
		return "catalagoanimal/animal/form";
	}

	@GetMapping({ "/form/{id}" })
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Animal");
		Animal editar = animalDao.find(id);
		model.addAttribute("animal", editar);
		return "catalagoanimal/animal/form";
	}

	@PostMapping({ "/guardar" })
	public String guardar(@Valid Animal animal, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Animales");
			return "catalagoanimal/animal/form";
		}

		
		if (animal.getId() != null && animal.getId() > 0) {
			animalDao.update(animal);
		} else {
			animalDao.insert(animal);
		}
		sesion.setComplete();
		return "redirect:/animal";
	}
	
	@GetMapping({ "/eliminar/{id}" })
	public String eliminar(@PathVariable Long id, Model model) {
		if (id != null && id > 0) {
			animalDao.delete(id);
		}
		return "redirect:/animal";
	}

}
