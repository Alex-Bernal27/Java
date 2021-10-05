package com.fcfm.Tarea.controllers;

import javax.validation.Valid;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.fcfm.Tarea.models.dao.PrestamoDao;
import com.fcfm.Tarea.models.entity.Cliente;
import com.fcfm.Tarea.models.entity.Prestamo;

@Controller
@RequestMapping(path = "/prestamo")
@SessionAttributes("prestamo")
public class PrestamoController {





	
	@Autowired
	private PrestamoDao prestamoDao;
	
	@Autowired
	private ClienteDao clienteDao;
	
	@GetMapping({ "", "/" })
	public String alumnos(Model model) {
		model.addAttribute("titulo", "prestamos");
		model.addAttribute("prestamos", prestamoDao.findAll());
		return "prestamo/form";
	}

	
	@GetMapping({ "/nuevo" })
	public String form(Model model) {
		model.addAttribute("titulo", "Prestamo");
		Prestamo nuevo = new Prestamo();
		model.addAttribute("prestamo", nuevo);
		Date date = new Date();
		nuevo.setFechacreacion(date);
		nuevo.setPagado(false);
		nuevo.setAbonototal(0F);
		return "prestamo/form";
	}
	
	@GetMapping({ "/busqueda/id"} ) 
	public String busquedaIdC(@RequestParam Long id, Model model) {
		
		if (id == null || id == 0 ) {
			model.addAttribute("busqueda", 3);
			return "busqueda";
		}
		
		model.addAttribute("prestamos", prestamoDao.findIdC(id));
		
		return "prestamo/lista";
	}
	
	@GetMapping({ "/busqueda/fechas"} ) 
	public String busquedaIdC(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate, 
			@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate, Model model) {
		
		if (startDate == null || endDate== null ) {
			model.addAttribute("busqueda", 4);
			return "busqueda";
		}
		
		model.addAttribute("prestamos", prestamoDao.findBFechas(startDate, endDate));
		
		return "prestamo/lista";
	}
	
	@GetMapping(path= "/busqueda/activos" )
	public String busquedaAct(Model model) {
		model.addAttribute("titulo", "Prestamos");
		model.addAttribute("prestamos", prestamoDao.findActivos());
		return "prestamo/lista";
	}
	
	@GetMapping(path= "/busqueda/pagados" )
	public String busquedaPagados(Model model) {
		model.addAttribute("titulo", "Prestamos");
		model.addAttribute("prestamos", prestamoDao.findPagados());
		return "prestamo/lista";
	}

	
	@PostMapping({ "/guardar" })
	public String guardar(@Valid Prestamo prestamo, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Prestamo");
			return "prestamo/form";
		}
		
		Integer flag = 0;
		Integer flag2 = 0;
		Cliente clmen = new Cliente();
		if (prestamo.getId() != null && prestamo.getId() > 0) {
			System.out.println("si pasa por el update");
			prestamoDao.update(prestamo);
		} else {
			Cliente cliente = prestamo.getCliente_id();
			clmen = cliente;
			List<Prestamo> prestamos = prestamoDao.findAll();
			List<Cliente> clientes = clienteDao.findAll();
			for (Prestamo p : prestamos) {
				if (p.getCliente_id().getId() == cliente.getId()) {
					model.addAttribute("error", "El ID del cliente ya tiene un prestamo");
					flag++;
					return "prestamo/form";
				}
			}
			for (Cliente c : clientes) {
				if (c.getId() == cliente.getId()) {
					flag2++;
				}
			}
			if(flag2==0) {
				model.addAttribute("error2", "El cliente no existe");
				return "prestamo/form";
			}
			if(flag==0)prestamoDao.insert(prestamo);
		}
		sesion.setComplete();
		
		//Deberia ser a el menuAdmin
		System.out.println(clmen.getId());
		System.out.println(clmen.getRol());
		model.addAttribute("cliente", clmen);
		return "redirect:/menu";
	}
	
	@PostMapping({ "/guardar/admin" })
	public String guardarAdmin(@Valid Prestamo prestamo, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Prestamo");
			return "prestamo/form";
		}
		
		Integer flag = 0;
		Integer flag2 = 0;
		Cliente clmen = new Cliente();
		if (prestamo.getId() != null && prestamo.getId() > 0) {
			System.out.println("si pasa por el update");
			prestamoDao.update(prestamo);
		} else {
			Cliente cliente = prestamo.getCliente_id();
			clmen = cliente;
			List<Prestamo> prestamos = prestamoDao.findAll();
			List<Cliente> clientes = clienteDao.findAll();
			for (Prestamo p : prestamos) {
				if (p.getCliente_id().getId() == cliente.getId()) {
					model.addAttribute("error", "El ID del cliente ya tiene un prestamo");
					flag++;
					return "prestamo/form";
				}
			}
			for (Cliente c : clientes) {
				if (c.getId() == cliente.getId()) {
					flag2++;
				}
			}
			if(flag2==0) {
				model.addAttribute("error2", "El cliente no existe");
				return "prestamo/form";
			}
			if(flag==0)prestamoDao.insert(prestamo);
		}
		sesion.setComplete();
		return "menuAdmin";
	}
	
	@PostMapping({ "/guardar/cliente" })
	public String guardarcliente(@Valid Prestamo prestamo, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Prestamo");
			return "prestamo/formCliente";
		}
		Cliente cliente = prestamo.getCliente_id();
		Integer flag = 0;
		if (prestamo.getId() != null && prestamo.getId() > 0) {
			prestamoDao.update(prestamo);
		} else {
			List<Prestamo> prestamos = prestamoDao.findAll();

			for (Prestamo p : prestamos) {
				if (p.getCliente_id().getId() == cliente.getId()) {
					model.addAttribute("error", "El ID del cliente ya tiene un prestamo");
					flag++;
					return "prestamo/formCliente";
				} 
			}
			if(flag==0)prestamoDao.insert(prestamo);
		}
		sesion.setComplete();
		model.addAttribute("titulo", "Menu");
		model.addAttribute("h1", "Menu");
		cliente.setRol(false);
		model.addAttribute("cliente", cliente);
		return "menu";
	}
	
	
	@PostMapping({ "/guardarAbono" })
	public String guardarAbono(@Valid Prestamo prestamo, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Prestamo");
			return "prestamo/formAbonar";
		}

		if (prestamo.getId() != null && prestamo.getId() > 0) {
				prestamoDao.update(prestamo);
			}
		else {
			prestamoDao.insert(prestamo);
		}
		sesion.setComplete();
		return "menuAdmin";
	}
	
	@PostMapping({ "cliente/guardarAbono" })
	public String clienteGuardarAbono(@Valid Prestamo prestamo, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Prestamo");
			return "prestamo/formAbonar";
		}
		Cliente editar = clienteDao.find(prestamo.getCliente_id().getId());
		if (prestamo.getId() != null && prestamo.getId() > 0) {
			editar.setMonto(editar.getMonto()-prestamo.getAbonototal());
			clienteDao.update(editar);
			prestamoDao.update(prestamo);
		} else {
			prestamoDao.insert(prestamo);
		}
		sesion.setComplete();
		model.addAttribute("titulo", "Menu");
		model.addAttribute("h1", "Menu");
		editar.setRol(false);
		model.addAttribute("cliente", editar);
		return "menu";
	}
	
	@GetMapping(path= "/busqueda/todos" )
	public String clientes(Model model) {
		model.addAttribute("titulo", "Prestamo");
		model.addAttribute("prestamos", prestamoDao.findAll());
		return "prestamo/lista";
	}
	
	
	@GetMapping({ "/form/{id}" })
	public String editar(@PathVariable Long id, Model model, @RequestParam(value = "abonar", defaultValue = "0") String abono) {
		model.addAttribute("titulo", "Prestamo");
		Prestamo editar = prestamoDao.find(id);
		editar.setAbonototal(0F);
		model.addAttribute("prestamo", editar);
		return "Prestamo/formAbonar";
	}
	
	@GetMapping({ "/cliente/nuevo/{id}" })
	public String clienteNuevo(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Prestamo");
		Cliente editar = clienteDao.find(id);
		Prestamo nuevo = new Prestamo();
		nuevo.setCliente_id(editar);
		nuevo.setAbonototal(0F);
		Date date = new Date();
		nuevo.setFechacreacion(date);
		Calendar calendar = Calendar.getInstance();
		int dias = 15;
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		nuevo.setFechaexpiracion(calendar.getTime());
		nuevo.setPagado(false);
		model.addAttribute("prestamo", nuevo);
		return "prestamo/formCliente";
	}
	
	@GetMapping({ "/cliente/form/{id}" })
	public String abonarCliente(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Prestamo");
		Cliente editar = clienteDao.find(id);
		List<Prestamo> prestamos = prestamoDao.findAll();
		for(Prestamo p: prestamos) {
			if(p.getCliente_id().getId()==editar.getId()) {
				p.setAbonototal(0F);
				model.addAttribute("prestamo", p);
			}
		}
		return "prestamo/formAbonarCliente";
	}

}
