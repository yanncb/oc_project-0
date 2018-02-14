package com.bank.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bank.domain.Product;
import com.bank.repository.ProductRepository;

@Service
public class ProductService {
	
	@Inject
	private ProductRepository productRepository;
	
	public List<Product> products() {
		return productRepository.products();
	}

	public Product product(Integer id) {
		return productRepository.product(id);
	}
}
