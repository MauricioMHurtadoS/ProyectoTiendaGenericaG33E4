package mintic.edu.g33.e4.tgback.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mintic.edu.g33.e4.tgback.exception.ResourceNotFoundException;
import mintic.edu.g33.e4.tgback.model.Login;
import mintic.edu.g33.e4.tgback.repository.ILoginRepository;
@Service
@Transactional
public class LoginServiceImp implements LoginService {
	
	@Autowired
	private ILoginRepository loginRepo;
	
	@Override
	public Login getLoginById(String userName) {
		
		Optional<Login> loginDb=this.loginRepo.findById(userName);
		if(loginDb.isPresent()) {
			return loginDb.get();
		}else {
			throw new ResourceNotFoundException("Registro no encontrado copn el id: "+userName);
		}
		
	}

}
