package com.shapeshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERS")
public class OrderEntity {

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	@Id
	@Column(name="ORDER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private CompanyEntity company = new CompanyEntity();
	
	@ManyToMany
	private List<ProductEntity> selectedProducts = new ArrayList<>();
	
	@OneToOne
	private CreditCardEntity creditCardEntity;

	@OneToOne
	private AddressEntity addressEntity;

	@Column(name="ORDER_DATE")
	private Date date;
	@Column(name="ORDER_PAYMENTTYPE")
	private PaymentType paymentType;
	@Column(name="ORDER_DELIVERYTYPE")
	private DeliveryType deliveryType;
	
	@Column(name="ORDER_AMOUNT")
	private String amount;


	protected OrderEntity() {
	}

	public OrderEntity( Date date, 
								PaymentType payment, 
								DeliveryType deliveryType,
								AddressEntity address, 
								CreditCardEntity creditCard, 
								ArrayList<ProductEntity> selectedProducts, 
								CompanyEntity company) {
		super();
		this.addressEntity = address;
		this.creditCardEntity = creditCard;
		this.date = date;
		this.paymentType = payment;
		this.deliveryType = deliveryType;
		this.selectedProducts = selectedProducts;
		this.company = company;
	}

	public OrderEntity(String name, 
								String telephone, 
								Date date, PaymentType payment, 
								DeliveryType deliveryType,
								String string3, CompanyEntity company) {
		super();
		this.date = date;
		this.paymentType = payment;
		this.deliveryType = deliveryType;
		this.company = company;
		
	}

	public CreditCardEntity getCreditCardEntity() {
		return creditCardEntity;
	}

	public void setCreditCardEntity(CreditCardEntity creditCardEntity) {
		this.creditCardEntity = creditCardEntity;
	}

	public AddressEntity getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}
	
	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public PaymentType getPayment() {
		return paymentType;
	}

	public void setPayment(PaymentType payment) {
		this.paymentType = payment;
	}

	public DeliveryType getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DeliveryType deliveryType) {
		this.deliveryType = deliveryType;
	}
	
	public List<ProductEntity> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(List<ProductEntity> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", company=" + company + ", selectedProducts=" + selectedProducts
				+ ", creditCardEntity=" + creditCardEntity + ", addressEntity=" + addressEntity + ", date=" + date
				+ ", paymentType=" + paymentType + ", deliveryType=" + deliveryType + ", amount=" + amount + "]";
	}
}
