package com.shapeshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO rename to COntact data 
 *
 */

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	
	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String street;
	private String postcode;

	public AddressEntity(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
