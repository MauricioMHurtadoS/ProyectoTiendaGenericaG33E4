package mintic.edu.g33.e4.tgback.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mintic.edu.g33.e4.tgback.exception.ResourceNotFoundException;
import mintic.edu.g33.e4.tgback.model.Client;
import mintic.edu.g33.e4.tgback.model.Product;
import mintic.edu.g33.e4.tgback.repository.IProductRepository;
@Service
@Transactional
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public Product createProduct(Product product) {

		return productRepo.save(product);
		
	}

	@Override
	public Product updateProduct(Product product) {
		
		Optional<Product> productDb=this.productRepo.findById(product.getCodigo_producto());
		
		if(productDb.isPresent()) {
			
			Product productUpdate=productDb.get();
			productUpdate.setCodigo_producto(product.getCodigo_producto());
			productUpdate.setNombre_producto(product.getNombre_producto());
			productUpdate.setNitproveedor(product.getNitproveedor());
			productUpdate.setPrecio_compra(product.getPrecio_compra());
			productUpdate.setIvacompra(product.getIvacompra());
			productUpdate.setPrecio_venta(product.getPrecio_venta());
			productRepo.save(productUpdate);
			
			return productUpdate;			
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con el id: "+product.getCodigo_producto());
		}
		
	}

	@Override
	public List<Product> getAllProduct() {

		return productRepo.findAll();
		
	}

	@Override
	public Product getProductById(Integer productId) {
		
		Optional<Product> productDb=this.productRepo.findById(productId);
		if(productDb.isPresent()) {
			return productDb.get();
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con el id: "+productId);
		}
		
	}

	@Override
	public void delProduct(Integer productId) {
		
		Optional<Product> productDb=this.productRepo.findById(productId);
		if(productDb.isPresent()) {
			this.productRepo.delete(productDb.get());
		}else {
			throw new ResourceNotFoundException("Registro no encontrado con el id: "+productId);
		}

	}

}
