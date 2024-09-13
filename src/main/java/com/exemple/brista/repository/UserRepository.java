package com.exemple.brista.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.exemple.brista.entity.Roteiro;
import com.exemple.brista.entity.user.User;



@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	UserDetails findByLogin(String login);
	

	
}
