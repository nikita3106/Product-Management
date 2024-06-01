package com.product.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAll();

}
