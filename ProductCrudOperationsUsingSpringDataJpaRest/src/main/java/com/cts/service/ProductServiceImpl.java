package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;

@Service("productService")
public  class ProductServiceImpl implements ProductService {
	Logger log=LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductRepository repository;
	
	@Override
	public String saveProduct(Product product) {
		log.warn("In ProductServiceImpl saveproduct method.........");
		Product pro=repository.save(product);
		if(pro !=null)
		return "Product saved successfully";
		else
			return "something went wrong";
				
	}

	@Override
	public Product updateProduct(Product product) {
		Product pro=repository.save(product);
		return pro;
	}
 
	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);
		return "Product Deleted";
	}
 
	@Override
	public Product getProduct(int productId) throws ProductNotFound { 
		Optional<Product>optional=repository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("Product id is not found");
	}
 
	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
 
	@Override
	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice) {
 
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}
 
	@Override
	public List<Product> getAllProductsByCategory(String category) {
 
		return repository.findByProductCategory(category);
	}

	@Override
	public List<Product> getProductsOverThePrice(int price) {
		return repository.findByProductPriceGreaterThan(price);
	}
 
	
}
