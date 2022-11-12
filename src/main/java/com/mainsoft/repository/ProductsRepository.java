package com.mainsoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mainsoft.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long>{

	@Query(value = "SELECT * FROM products", nativeQuery = true)
	public List<Products> findAllProducts();
}
