package mintic.edu.g33.e4.tgfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import mintic.edu.g33.e4.tgfront.client.IClientStore;
import mintic.edu.g33.e4.tgfront.model.Login;

@Controller
public class AppController {
	
	@Autowired
	IClientStore clientStore;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}

	@GetMapping("/productos")
	public String products() {
		return "productos";
	}

	@GetMapping("/new")
	public String newProduct() {
		return "new";
	}
	
	@PostMapping("/login")
	public String login(Model model, Login login) {
		int validLogin=clientStore.login(login);
		
		if(validLogin==1) {
			return "menu";
		}else {
			model.addAttribute("error", "Usuario o onctraseña invalidos");
			return "index";
		}
	}
	
}
