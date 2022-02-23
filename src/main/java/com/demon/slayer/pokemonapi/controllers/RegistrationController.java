package com.demon.slayer.pokemonapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demon.slayer.pokemonapi.entity.User;
import com.demon.slayer.pokemonapi.service.RegistrationService;

@RestController
@RequestMapping("/api")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) {
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempUser = user.getUsername();
		String tempPass = user.getPassword();
		System.out.println(user.getPassword());
		User userObj = null;
		if(tempUser != null && tempPass != null) {
		userObj = service.getByUserAndPassword(tempUser, tempPass);
		}
		if(userObj == null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	} 
	
}
