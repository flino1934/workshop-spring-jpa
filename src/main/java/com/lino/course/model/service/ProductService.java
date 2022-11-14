package com.lino.course.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino.course.model.entities.Product;
import com.lino.course.model.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {

		return productRepository.findAll();
	}

	public Product findById(Long id) {

		Optional<Product> product = productRepository.findById(id);
		return product.get();

	}

}
