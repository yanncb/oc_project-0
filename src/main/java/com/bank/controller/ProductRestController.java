package com.bank.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bank.domain.Product;
import com.bank.service.ProductService;


@RestController
public class ProductRestController {
	
	@Inject
	private ProductService productService;

	@GetMapping("/products.json")
	public List<Product> productsAsJson (Model model) {
		return productService.products();
	}

	@GetMapping("/products/{id}/details.json")
	public Product product	(@PathVariable Integer id, Model model) {
		return productService.product(id);
	}
}
