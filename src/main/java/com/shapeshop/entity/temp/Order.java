//package com.shapeshop.entity.temp;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.ElementCollection;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.OrderColumn;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "ORDERS")
//public class Order {
//
//	@Id
//	@Column(name="ORDERX_ID")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
//	@OneToMany
//	private List<OrderItem> selectedProducts = new ArrayList<>();
//	
//    @ElementCollection @OrderColumn
//    private List<OrderItem> orderItems = new ArrayList<>();
//
//
//	protected Order() {
//	}
//
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//	
//	public List<OrderItem> getSelectedProducts() {
//		return selectedProducts;
//	}
//
//	public void setSelectedProducts(List<OrderItem> selectedProducts) {
//		this.selectedProducts = selectedProducts;
//	}
//	
//	public List<OrderItem> getOrderItems() {
//		return orderItems;
//	}
//
//	public void setOrderItems(List<OrderItem> orderItems) {
//		this.orderItems = orderItems;
//	}
//}
