//package com.shapeshop.entity.temp;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "ORDERS_ITEM")
//public class OrderItem {
//
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//
//	@ManyToOne
//	private Product product = new Product();
//
////	@ManyToOne
////	private OrderEntity order = new OrderEntity();
//	
//	private int amount;
//
//	protected OrderItem() {
//	}
//
//	public OrderItem(Product product, int amount) {
//		super();
//		this.product = product;
//		this.amount = amount;
//	}
//
//	public int getAmount() {
//		return amount;
//	}
//
//	public void setAmount(int amount) {
//		this.amount = amount;
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
//}
