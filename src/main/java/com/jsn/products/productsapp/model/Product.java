package com.jsn.products.productsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * create table products(id bigint, title varchar(100), sku varchar(100), description varchar(100));
 * 
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String sku;
    private String description;

    // Constructors, getters, setters...
    public Product() {
    }

    public Product(String title, String sku, String description) {
        this.title = title;
        this.sku = sku;
        this.description = description;
    }   

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSku() {
        return sku;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
