package com.bank.domain;

public class Product {
	
	Integer id;
	String name, description, details;
	double interest;

	public Product(int id, String name, String description, String details, double interest) {
		super();
		this.id=id;
		this.name = name;
		this.description = description;
		this.details = details;
		this.interest=interest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

}
