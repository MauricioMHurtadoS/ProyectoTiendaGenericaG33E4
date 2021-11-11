package mintic.edu.g33.e4.tgback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mintic.edu.g33.e4.tgback.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
