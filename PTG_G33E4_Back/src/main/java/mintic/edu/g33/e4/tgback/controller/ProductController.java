package mintic.edu.g33.e4.tgback.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mintic.edu.g33.e4.tgback.model.Product;
import mintic.edu.g33.e4.tgback.service.ProductService;

@RestController
@CrossOrigin(origins="*", methods={RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/productos")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/productos")
	public ResponseEntity<List<Product>> getAllProducts(){
		return ResponseEntity.ok().body(productService.getAllProduct());
	}

	@GetMapping("/productos/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id){
		return ResponseEntity.ok().body(productService.getProductById(id));
	}

	@PostMapping("/productos")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		return ResponseEntity.ok().body(this.productService.createProduct(product));
	}

	@PutMapping("/productos")
	public ResponseEntity<Product> updatePorduct(@PathVariable Integer id,@RequestBody Product product){
		product.setCodigo_producto(id);
		return ResponseEntity.ok().body(this.productService.updateProduct(product));
	}

	@DeleteMapping("/productos")
	public HttpStatus deleteProduct(@PathVariable Integer id){
		this.productService.delProduct(id);
		return HttpStatus.OK;
	}
	
}
