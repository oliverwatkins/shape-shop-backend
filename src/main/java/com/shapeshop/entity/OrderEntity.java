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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERS")
public class OrderEntity {



	@Id
	@Column(name="ORDER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

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
	
//	@Column(name="ORDER_NAME")
//	private String name;
//	@Column(name="ORDER_STREET")
//	private String street;
//	@Column(name="ORDER_POSTCODE")
//	private String postCode;
//	@Column(name="ORDER_TELEPHONE")
//	private String telephone;
//	@Column(name="ORDER_EMAIL")
//	private String email;
//	
	
	@Column(name="ORDER_AMOUNT")
	private String amount;


//	private String nameCC;
//	private String numberCC;
//	private String zipherCC;
//	private String expDateCC;


	protected OrderEntity() {
	}

	public OrderEntity( Date date, PaymentType payment, DeliveryType deliveryType,
			AddressEntity address, CreditCardEntity creditCard, ArrayList<ProductEntity> selectedProducts) {
		super();
		
		this.addressEntity = address;
		this.creditCardEntity = creditCard;
//		this.name = name;
//		this.telephone = telephone;
		this.date = date;
		this.paymentType = payment;
		this.deliveryType = deliveryType;
		this.selectedProducts = selectedProducts;
	}

	public OrderEntity(
			String name, 
			String telephone, 
			Date date, PaymentType payment, DeliveryType deliveryType,
			String string3) {
		
//		this.addressEntity = address;
//		this.creditCardEntity = creditCard;
//		this.name = name;
//		this.telephone = telephone;
		this.date = date;
		this.paymentType = payment;
		this.deliveryType = deliveryType;
		
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
//
//	public String getStreet() {
//		return street;
//	}
//
//	public void setStreet(String street) {
//		this.street = street;
//	}
//
//	public String getPostCode() {
//		return postCode;
//	}
//
//	public void setPostCode(String postCode) {
//		this.postCode = postCode;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}

	
//	
//	public String getNameCC() {
//		return nameCC;
//	}
//
//	public void setNameCC(String nameCC) {
//		this.nameCC = nameCC;
//	}
//
//	public String getNumberCC() {
//		return numberCC;
//	}
//
//	public void setNumberCC(String numberCC) {
//		this.numberCC = numberCC;
//	}
//
//	public String getZipherCC() {
//		return zipherCC;
//	}
//
//	public void setZipherCC(String zipherCC) {
//		this.zipherCC = zipherCC;
//	}
//
//	public String getExpDateCC() {
//		return expDateCC;
//	}
//
//	public void setExpDateCC(String expDateCC) {
//		this.expDateCC = expDateCC;
//	}
//
//	public String[] getItems() {
//		return items;
//	}
//
//	public void setItems(String[] items) {
//		this.items = items;
//	}

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

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

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

//	public String getTelephone() {
//		return telephone;
//	}
//
//	public void setTelephone(String telephone) {
//		this.telephone = telephone;
//	}
	
	public List<ProductEntity> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(List<ProductEntity> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", selectedProducts=" + selectedProducts + ", creditCardEntity="
				+ creditCardEntity + ", addressEntity=" + addressEntity + ", date=" + date + ", paymentType="
				+ paymentType + ", deliveryType=" + deliveryType + ", amount=" + amount + "]";
	}
}
