package com.demon.slayer.pokemonapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demon.slayer.pokemonapi.entity.User;
import com.demon.slayer.pokemonapi.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}
	
	/* public User fetchUserByUserAndPassword(String username, String password) {
		return repo.findByUserAndPassword(username, password);
	} */
	
	public User getByUserAndPassword(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}

}
