package com.springcore.service.Impl;

import com.springcore.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcore.model.Product;
import com.springcore.repository.ProductRepository;
import com.springcore.service.ProdService;

import java.util.List;

@Service
public class ProdServiceImpl implements ProdService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	public ProdServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// create Product

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	// update Product
	@Override
	public Product updateProdQuantity(Integer prodQuantity, Integer prodId) {
		Product quant = this.productRepository.findById(prodId).orElseThrow();
		quant.setProdQuantity(prodQuantity);
		Product updateQuantity = this.productRepository.save(quant);
		return updateQuantity;

	}

	@Override
	public List<Product>  getAllProducts(){
		List<Product> product = this.productRepository.findAll();
		return product;
	}

	@Override
	public void deleteProdById(Integer prodId) {
		Product product =this.productRepository.findById(prodId).orElseThrow();
		this.productRepository.delete(product);
	}


	@Override
	public Product getProdById(Integer prodId) {
		Product product = this.productRepository.findById(prodId).orElseThrow();
		return product;
	}
	@Override
	public List<Product> getAllProductByUser (Users users){
		List<Product> products=this.productRepository.findByUser(users);
		return products;

	}

}
