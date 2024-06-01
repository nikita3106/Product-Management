package com.product.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.model.Product;
import com.product.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/saveproduct")
	public ResponseEntity<?> saveProduct(@RequestBody Product product)
	{
		return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<?> getAllProducts()
	{
		return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id)
	{
		return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<?> deleteFromProduct(@PathVariable Integer id)
	{
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product deleted successfully: ",HttpStatus.OK);
	}
	@PutMapping("/upadteproduct/{id}")
	public ResponseEntity<?> editProduct(@RequestBody Product product,@PathVariable Integer id)
	{
		return new ResponseEntity<>(productService.upadteproduct(product,id),HttpStatus.CREATED);

	}
}











