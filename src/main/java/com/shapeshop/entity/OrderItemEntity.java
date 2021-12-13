package com.shapeshop.entity;

import javax.persistence.*;

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
