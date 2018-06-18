package com.lambazon.domain;

public class Product {

    private Integer id;
    private String name, description, details;
    private int quantity;
    private double price;

    public Product(int id, int quantity, double price, String name, String description) {
        setId(id);
        setQuantity(quantity);
        setPrice(price);
        setName(name);
        setDescription(description);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    /**
     * Add "if" for prevent the stock from being negative.
     *
     * @param quantity : number of product
     */

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }

    public double getPrice() {
        return price;
    }

    /**
     * In case of negative price or zero writing zero and if the price is greater than 1000 writing 1000.
     *
     * @param price price of product.
     */
    public void setPrice(double price) {
        if (price <= 0) {
            this.price = 0;
        } else if (price >= 1000) {
            this.price = 1000;
        } else {
            this.price = price;
        }
    }

    /**
     * the price according to the total stock remaining
     *
     * @return inventory price
     */
    public double getInventoryPrice() {

        return getPrice() * getQuantity();
    }
}

