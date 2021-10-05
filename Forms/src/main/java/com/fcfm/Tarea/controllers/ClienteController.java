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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fcfm.Tarea.models.dao.ClienteDao;
import com.fcfm.Tarea.models.entity.Cliente;
import com.fcfm.Tarea.models.entity.Prestamo;

@Controller
@RequestMapping(path = "/cliente")
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private ClienteDao clienteDao; 
	
	@GetMapping({ "", "/" })
	public String alumnos(Model model) {
		model.addAttribute("titulo", "clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "busquedaClientes/clientes/lista";
	}

	@GetMapping(path= "/busqueda/todos" )
	public String clientes(Model model) {
		model.addAttribute("titulo", "clientes");
		model.addAttribute("clientes", clienteDao.findAll());
		return "busquedaClientes/clientes/lista";
	}

	@GetMapping({ "/busqueda/{id}" })
	public String busqueda(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Cliente");
		Cliente editar = clienteDao.find(id);
		model.addAttribute("cliente", editar);
		model.addAttribute("val", false);
		return "busquedaClientes/clientes/form";
	}
	
	@GetMapping({ "/nuevo" })
	public String form(Model model) {
		model.addAttribute("titulo", "Cliente");
		Cliente nuevo = new Cliente();
		nuevo.setRol(false);
		model.addAttribute("cliente", nuevo);
		return "busquedaClientes/clientes/formAdmin";
	}

	@GetMapping({ "/form/{id}" })
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Cliente");
		Cliente editar = clienteDao.find(id);
		model.addAttribute("cliente", editar);
		model.addAttribute("val", true);
		return "busquedaClientes/clientes/formAdmin";
	}

	@PostMapping({ "/guardar" })
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus sesion) {
		cliente.setRol(false);
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Cliente");
			return "busquedaClientes/clientes/form";
		}
		if (cliente.getId() != null && cliente.getId() > 0) {
			clienteDao.update(cliente);
		} else {
			clienteDao.insert(cliente);
		}
		sesion.setComplete();
		model.addAttribute("titulo", "Menu");
		model.addAttribute("h1", "Menu");
		cliente.setRol(false);
		model.addAttribute("cliente", cliente);
		return "menu";
	}
	
	@PostMapping({ "/guardar/admin" })
	public String guardarAdmin(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Cliente");
			return "busquedaClientes/clientes/form";
		}

		
		if (cliente.getId() != null && cliente.getId() > 0) {
			clienteDao.update(cliente);
		} else {
			clienteDao.insert(cliente);
		}
		sesion.setComplete();
		return "menuAdmin";
	}
	
	
	@GetMapping({ "/busqueda/nombre"} ) 
	public String busquedanombre(@RequestParam String nombre, Model model) {
		
		if (nombre.length() == 0 ) {
			model.addAttribute("busqueda", 1);
			return "busqueda";
		}
		
		model.addAttribute("clientes", this.clienteDao.findName(nombre));
		
		return "busquedaClientes/clientes/lista";
	}
	
	@GetMapping({ "/busqueda/id"} ) 
	public String busquedaId(@RequestParam Long id, Model model) {
		
		if (id == null || id == 0 ) {
			model.addAttribute("busqueda", 2);
			return "busqueda";
		}
		
		model.addAttribute("clientes", this.clienteDao.find(id));
		
		return "busquedaClientes/clientes/lista";
	}
	

	@GetMapping(path= "/montoTotal" )
	public String montoTotal(Model model) {
		model.addAttribute("titulo", "Clientes");
		model.addAttribute("montoT", clienteDao.montoTotal());
		return "result";
	}
	
	@GetMapping(path= "/clienteM" )
	public String clienteM(Model model) {
		model.addAttribute("titulo", "clientes");
		model.addAttribute("clientes", clienteDao.clienteMdinero());
		return "busquedaClientes/clientes/lista";
	}
	
	@GetMapping({ "/eliminar/{id}" }) 
	public String eliminar(@PathVariable Long id, Model model) {
		if (id != null && id > 0) {
			clienteDao.delete(id);
		}
		return "redirect:/cliente";
	}
	
	@GetMapping({ "/formAbono/{id}" })
	public String editarAbono(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Cliente");
		Cliente editar = clienteDao.find(id);
		editar.setMonto(0F);
		model.addAttribute("cliente", editar);
		return "busquedaClientes/clientes/formAbonar";
	}

	@GetMapping({ "/formRetiro/{id}" })
	public String editarRetiro(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Cliente");
		Cliente editar = clienteDao.find(id);
		editar.setMonto(0F);
		model.addAttribute("cliente", editar);
		return "busquedaClientes/clientes/formRetirar";
	}
	
	@PostMapping({ "/abonarMonto" })
	public String guardarAbono(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Prestamo");
			return "busquedaClientes/clientes/abonar";
		}
		
		clienteDao.abonar(cliente);
		sesion.setComplete();
		model.addAttribute("titulo", "Menu");
		model.addAttribute("h1", "Menu");
		cliente.setRol(false);
		model.addAttribute("cliente", cliente);
		return "menu";
	}
	
	@PostMapping({ "/retirarMonto" })
	public String retirarAbono(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Prestamo");
			return "busquedaClientes/clientes/retirar";
		}
		clienteDao.retirar(cliente);
		sesion.setComplete();
		model.addAttribute("titulo", "Menu");
		model.addAttribute("h1", "Menu");
		cliente.setRol(false);
		model.addAttribute("cliente", cliente);
		return "menu";
	}
	
}
