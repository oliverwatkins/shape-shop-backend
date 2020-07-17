package com.shapeshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERS_ITEM")
public class OrderItemEntity {


	@Id
	@Column(name="ORDERS_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany
	private ProductEntity product = new ProductEntity();

	@OneToMany
	private OrderEntity order = new OrderEntity();

	
	@Column(name="ORDER_AMOUNT")
	private String amount;


	protected OrderItemEntity() {
	}


	public OrderItemEntity(ProductEntity product, OrderEntity order, String amount) {
		super();
		this.product = product;
		this.order = order;
		this.amount = amount;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
