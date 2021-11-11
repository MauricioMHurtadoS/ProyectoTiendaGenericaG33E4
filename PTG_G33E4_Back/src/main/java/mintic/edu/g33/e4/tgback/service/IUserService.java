package mintic.edu.g33.e4.tgback.service;

import org.springframework.http.ResponseEntity;

import mintic.edu.g33.e4.tgback.model.Login;

public interface IUserService {

	int login(Login user);
	
	ResponseEntity<?> ingresar(Login user);
	
}
