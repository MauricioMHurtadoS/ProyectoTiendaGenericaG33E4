package mintic.edu.g33.e4.tgback.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import mintic.edu.g33.e4.tgback.model.Login;
import mintic.edu.g33.e4.tgback.model.Product;
import mintic.edu.g33.e4.tgback.repository.ITypeDocument;
import mintic.edu.g33.e4.tgback.service.IProductService;
import mintic.edu.g33.e4.tgback.service.IUserService;

@Controller
public class AppController {

	@Autowired
	private IProductService servicio;
		
	@Autowired
	IUserService iUsuario;
	
	@Autowired
	ITypeDocument iTipoDocumento;
	
	@CrossOrigin(origins= {"http://localhost:8090"})
	@PostMapping("/loginclient")
	public int login(@RequestBody Login user) {
		int responseLogin=iUsuario.login(user);
		return responseLogin;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginCliente(@RequestBody Login user){
		return iUsuario.ingresar(user);
	}

	//Listado de Productos
	@CrossOrigin(origins= {"http://localhost:8090"})
	@RequestMapping("/productos")
	public String verProductos(Model model) {

		List<Product> listaProductos = servicio.listar();
		model.addAttribute("listaProductos", listaProductos);
		
		return "productos";
		
	}
	
	//Vista nuevo Producto
	@CrossOrigin(origins= {"http://localhost:8090"})
	@RequestMapping("/new")
	public String paginaNuevoProducto(Model model){
		
		Product producto = new Product();
		model.addAttribute("producto", producto);
		
		return "redirect:/nuevo_producto";
		
	}
	
	//Crear nuevo Producto
	@CrossOrigin(origins= {"http://localhost:8090"})
	@PostMapping("/save")
	public String saveProducto(@Valid @ModelAttribute("producto") Product producto, Errors errores,Model model) {
		
		if (errores.hasErrors()) {
			
			return "nuevo_producto";
			
		} else {
			servicio.save(producto);
			
			return "redirect:/productos";
			
		}
		
	}
	
	//Consultar Producto por codigo
	@CrossOrigin(origins= {"http://localhost:8090"})
	@GetMapping("/listar/{codigo_producto}")
	public String listarId(@PathVariable int codigo, Model model) {
		
		model.addAttribute("producto", servicio.listarId(codigo));
		
		return "editar_producto";
		
	}
	
	//Eliminar Producto por codigo
	@CrossOrigin(origins= {"http://localhost:8090"})
	@RequestMapping("/delete/{codigo_producto}")
	public String deleteProduct(@PathVariable(name="codigo_producto") int codigo){
		
		servicio.delete(codigo);
		
		return "redirect:/productos";
		
	}
	
	/**/
	
}
