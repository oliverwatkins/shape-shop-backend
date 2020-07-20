//package com.shapeshop.entity.temp;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "PRODUCT")
//public class Product {
//
//	@Id
//	@Column(name="PRODUCT_ID")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
//	@OneToMany
//	private List<OrderItem> orders = new ArrayList<>();
//	
//	private String name;
//
//	private BigDecimal price;
//	
//	protected Product() {}
//
//	public Product(String name) {
//		this.name = name;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public BigDecimal getPrice() {
//		return price;
//	}
//
//	public void setPrice(BigDecimal price) {
//		this.price = price;
//	}
//
//}
