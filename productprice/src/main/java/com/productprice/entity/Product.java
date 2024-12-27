package com.productprice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productID;
	
	private String productName;
	
	private double productprice;
	
	private long userId;
	
	private long orderId;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long productID, String productName, double productprice, long userId, long orderId) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productprice = productprice;
		this.userId = userId;
		this.orderId = orderId;
	}

	public long getProductID() {
		return productID;
	}

	public void setProductID(long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productprice=" + productprice
				+ ", userId=" + userId + ", orderId=" + orderId + "]";
	}
	
	
	
	
	
	

}
