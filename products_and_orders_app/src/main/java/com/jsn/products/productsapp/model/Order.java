package com.jsn.products.productsapp.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties
public class Order implements Serializable {	//serializable for ser/deser for kafka if sending as byteArray ?

	private static final long serialVersionUID = 123L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")	//knote: because hibernate converts camelCase params into snake_case for DB. sql genearlly used in snake_case
	private Long userId;
	@Column(name = "product_id")
	private Long productId; //for simplicity for now. normally it wud be many products and in diff table if RDBMS
	
	public Order() {
    }

	public Order(Long id, Long userId, Long productId) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
}
