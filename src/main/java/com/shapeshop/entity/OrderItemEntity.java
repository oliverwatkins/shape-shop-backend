package com.shapeshop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
//@Data
@Entity
@Table(name = "orders_item")
public class OrderItemEntity {

	@Id
	@Column(name = "orders_item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", nullable = false, updatable = false)
	private ProductEntity product = new ProductEntity();

	@Column(name = "order_amount")
	private int amount;

	protected OrderItemEntity() {
	}

	public OrderItemEntity(ProductEntity product, int amount) {
		this.product = product;
		this.amount = amount;
	}
}
