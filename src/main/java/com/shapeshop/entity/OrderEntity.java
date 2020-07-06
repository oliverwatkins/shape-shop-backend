package com.shapeshop.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String telephone;
	
	private Date date;
	private PaymentType payment;
	private DeliveryType deliveryType;
	private String address;

	protected OrderEntity() {}

	public OrderEntity(String name, String telephone, Date date, PaymentType payment,
			DeliveryType deliveryType, String address) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.date = date;
		this.payment = payment;
		this.deliveryType = deliveryType;
		this.setAddress(address);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return name;
	}

	public void setDescription(String description) {
		this.name = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	public PaymentType getPayment() {
		return payment;
	}

	public void setPayment(PaymentType payment) {
		this.payment = payment;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", description=" + name + ", date=" + date + "]";
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

}
