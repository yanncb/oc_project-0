package com.bank;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
	
	private static Map<Integer, Product> products;
	
	static {
		
		products = new HashMap<>();
		products.put(0, new Product(0, "Checking", "Free Checking without all the hassles", "Details", .05));
		products.put(1, new Product(1, "Savings", "Start earning 1.05% today", "Details",1.05));
		products.put(2, new Product(2, "CD", "Certificate of Deposit", "Details",.07));
		products.put(3, new Product(3, "Money Market", "Six free transactions per month", "Details",.08));
	}
	
	public List<Product> products() {
		return products.values()
				.stream()
				.sorted(Comparator.comparing(Product::getName))
				.collect(Collectors.toList());
	}
	
	public Product product(Integer id) {
		return products.get(id);
	}

}
