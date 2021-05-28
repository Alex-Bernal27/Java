package com.example.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.entity.Maestro;
import com.example.demo.models.entity.Role;
import com.example.demo.models.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.dto.MaestroRegistroDto;
import com.example.demo.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsuario(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsuario(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));	
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getTipo())).collect(Collectors.toList());
	}
	

	@Override
	public User saveAdmin(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getUsuario(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ADMIN")));
		
		return userRepository.save(user);
	}
	
	@Override
	public User saveMaestro(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getUsuario(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("MAESTRO")));
		
		return userRepository.save(user);
	}
	
	@Override
	public User saveAlumno(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getUsuario(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ALUMNO")));
		
		return userRepository.save(user);
	}

}
