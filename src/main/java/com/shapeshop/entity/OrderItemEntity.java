package com.shapeshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERS_ITEM")
public class OrderItemEntity {



	@Id
	@Column(name="ORDERS_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(optional=false, fetch=FetchType.EAGER)
	private ProductEntity product = new ProductEntity();

	@Column(name="ORDER_AMOUNT")
	private int amount;

	protected OrderItemEntity() {
	}

	public OrderItemEntity(ProductEntity product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
	}
	
 	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	

	@Override
	public String toString() {
		return "OrderItemEntity [id=" + id + ", product=" + product + ", amount=" + amount + "]";
	}

}
