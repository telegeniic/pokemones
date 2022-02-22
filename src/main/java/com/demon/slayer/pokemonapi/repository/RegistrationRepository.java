package com.demon.slayer.pokemonapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demon.slayer.pokemonapi.entity.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Long>{

	//@Query("From User WHERE username =:username and password =:password")
	public User findByUsernameAndPassword(String username, String password);
}
