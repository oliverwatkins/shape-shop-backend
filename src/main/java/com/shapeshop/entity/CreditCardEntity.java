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

	public CreditCardEntity(String number, String expDate, String name, String type) {
		super();
		this.number = number;
		this.expDate = expDate;
		this.name = name;
		this.type = type;
	}
	
	@Id
	@Column(name="CC_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	@Column(name = "NUMBER")
	private String number;
	@Column(name = "EXP_DATE")
	private String expDate;
	@Column(name = "NAME")
	private String name;
	@Column(name = "TYPE")
	private String type;

}
