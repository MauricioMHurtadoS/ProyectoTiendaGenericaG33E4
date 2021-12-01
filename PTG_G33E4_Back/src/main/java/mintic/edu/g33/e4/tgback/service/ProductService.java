package mintic.edu.g33.e4.tgback.service;

import java.util.List;

import mintic.edu.g33.e4.tgback.model.Product;

public interface ProductService {
	
	Product createProduct(Product product);
	
	Product updateProduct(Product product);
	
	List<Product> getAllProduct();
	
	Product getProductById(Integer productId);
	
	void delProduct(Integer productId);	
	
}