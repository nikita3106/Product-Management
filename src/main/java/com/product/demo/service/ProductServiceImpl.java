package com.product.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.model.Product;
import com.product.demo.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	public ProductRepository productRepo;
	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {	
		return productRepo.findById(id).get();
	}

	@Override
	public String deleteProduct(Integer id) {
	Product product=productRepo.findById(id).get();
	
		if(product!=null)
		{
			productRepo.delete(product);
			return "Product deleted successfully";
		}
		return "something wrong on server";
	}

	@Override
	public Product editProductByID(Product p, Integer id) {
		Product oldProduct=productRepo.findById(id).get();
		oldProduct.setProductName(p.getProductName());
		oldProduct.setDescription(p.getDescription());
		oldProduct.setPrice(p.getPrice());
		oldProduct.setStatus(p.getStatus());
		return productRepo.save(oldProduct);
	}

}
