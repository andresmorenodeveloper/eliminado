package com.mainsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainsoft.model.Products;
import com.mainsoft.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	ProductsRepository repository;
	
	public List<Products> getAllProducts(){
		return repository.findAllProducts();
	}
	
}
