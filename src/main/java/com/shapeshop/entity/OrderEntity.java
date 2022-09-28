package com.shapeshop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

//@Data
@Getter
@Setter

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private CompanyEntity company = new CompanyEntity();

	@OneToOne
	private CreditCardEntity creditCardEntity;

	@OneToOne
	private AddressEntity addressEntity;

	@OneToMany
	@JoinColumn(name = "order_id")
	private List<OrderItemEntity> orderItems;

	@Column(name = "order_date")
	private Date date;
	@Column(name = "order_payment_type")
	private PaymentType paymentType;
	@Column(name = "order_delivery_type")
	private DeliveryType deliveryType;
	@Column(name = "order_state")
	private OrderState state = OrderState.OPEN;

	protected OrderEntity() {
	}

	public OrderEntity(Date date, PaymentType payment, DeliveryType deliveryType, AddressEntity address,
			CreditCardEntity creditCard, CompanyEntity company) {
		this.addressEntity = address;
		this.creditCardEntity = creditCard;
		this.date = date;
		this.paymentType = payment;
		this.deliveryType = deliveryType;
		this.company = company;
	}

	public void addOrderItem(OrderItemEntity item) {
		orderItems.add(item);
	}
}
