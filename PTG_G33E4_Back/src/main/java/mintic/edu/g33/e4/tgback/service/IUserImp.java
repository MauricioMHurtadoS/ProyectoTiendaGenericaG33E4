package mintic.edu.g33.e4.tgback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mintic.edu.g33.e4.tgback.model.Login;
import mintic.edu.g33.e4.tgback.model.User;
import mintic.edu.g33.e4.tgback.repository.IUser;

@Service
public class IUserImp implements IUserService {

	@Autowired
	IUser iUser;
	
	@Override
	public int login(Login user) {
		int u=iUser.findByUserNameAndPassword(user.getUserName(), user.getPsswrd());
		return u;
	}

	@Override
	public ResponseEntity<?> ingresar(Login user) {
		Map<String, Object> response=new HashMap<>();
		User usr=null;
		try {
			usr=iUser.findByNameAndPassword(user.getUserName(), user.getPsswrd());
			if(usr==null) {
				response.put("Usuario", null);
				response.put("Mensaje", "Alerta:Usuario o Password incorrectos");
				response.put("statusCode", HttpStatus.OK.value());
				return new ResponseEntity<>(response,HttpStatus.OK);
				
			}else {
				response.put("Usuario", usr);
				response.put("Mensaje", "Datos correctos");
				response.put("statusCode", HttpStatus.OK.value());
				return new ResponseEntity<>(response,HttpStatus.OK);
			}
		} catch (Exception e) {
			response.put("Usuario", null);
			response.put("Mensaje", "Ha ocurrido un error");
			response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
