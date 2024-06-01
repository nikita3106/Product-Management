package com.product.demo.service;

import java.util.List;

import com.product.demo.model.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getAllProduct();
	public Product getProductById(Integer id);
	public String deleteProduct(Integer id);
	public Object upadteproduct(Product product, Integer id);
	
}
