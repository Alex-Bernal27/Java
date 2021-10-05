package com.fcfm.Tarea.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fcfm.Tarea.models.dao.ClienteDao;
import com.fcfm.Tarea.models.entity.Cliente;
import com.fcfm.Tarea.models.noentity.Login;


@Controller
@RequestMapping(path = "/menu")
@SessionAttributes("menu")
public class MenuController {
	
	@Autowired
	private ClienteDao clienteDao; 
	
	int flag = 0; 
	
	@PostMapping({ "/", "" })
	public String menu(@Valid Login login, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Cliente");
			return "login";
		}
		List<Cliente> lista = clienteDao.findAll();
		for(Cliente cl: lista) {
			if(cl.getUserName().contains(login.getUser()) && cl.getPass().contains(login.getPass())) {
				model.addAttribute("titulo", "Menu");
				model.addAttribute("h1", "Menu");
				model.addAttribute("variable", true);
				model.addAttribute("cliente", cl);
				return "menu";
			}
		}
		model.addAttribute("error", "El usuario no existe");
		return "login";
	}
	
	
	@GetMapping({ "/login" })
	public String login(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		 return "login";
	}
	
	@GetMapping({ "/menuAdmin" })
	public String menuAdmi(Model model) {
		
		 return "menuAdmin";
	}
	
	
	@GetMapping({"/busquedas"})
	public String busquedas(@RequestParam Integer busqueda, Model model) {
		
		model.addAttribute("titulo", "Busqueda");
		
		model.addAttribute("busqueda", busqueda);
		
		return "busqueda";
	}

}
