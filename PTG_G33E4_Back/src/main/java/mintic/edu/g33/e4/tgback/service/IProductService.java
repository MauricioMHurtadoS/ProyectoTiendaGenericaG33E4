package mintic.edu.g33.e4.tgback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mintic.edu.g33.e4.tgback.model.Product;
import mintic.edu.g33.e4.tgback.repository.IProductRepository;

@Service
@Transactional
public class IProductService {
	
	@Autowired
	private IProductRepository repo;
	
	//Listado de Productos
	public List<Product> listar(){
		return repo.findAll();
	}
	
	//Consultar Producto por codigo
	public Product listarId(int id) {
		return repo.findById(id).get();
	}
	
	//Guardar datos de Producto
	public void save(Product p) {
		repo.save(p);
	}
	
	//Eliminar Producto
	public void delete(int d) {
		repo.deleteById(d);
	}
	
}