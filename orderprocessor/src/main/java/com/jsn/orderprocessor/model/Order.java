package com.jsn.orderprocessor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Order {
	
	private Long id;
	private Long userId;
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