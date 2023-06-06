package com.springcore.service;

import com.springcore.model.Product;
import com.springcore.model.Users;

import java.util.List;

public interface ProdService {

	Product createProduct(Product product);

	Product updateProdQuantity(Integer prodQuantity, Integer prodId);

	List<Product> getAllProducts();


	void deleteProdById(Integer prodId);


	Product getProdById(Integer prodId);


	List<Product> getAllProductByUser (Users users);

}
	



