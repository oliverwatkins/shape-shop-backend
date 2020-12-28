package com.shapeshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_CARD")
public class CreditCardEntity {

	@Id
	@Column(name = "CC_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "NUMBER")
	private String number;
	@Column(name = "EXP_DATE")
	private String expDate;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;

	protected CreditCardEntity() {
	}

	public CreditCardEntity(String number, String expDate, String name, String type) {
		super();
		this.number = number;
		this.expDate = expDate;
		this.name = name;
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

}
