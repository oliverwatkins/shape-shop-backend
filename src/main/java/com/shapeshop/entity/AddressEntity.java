package com.shapeshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TODO rename to Contact data (Does not necessarily need to correspond to a
 * whole address)
 */

@Entity
@Table(name = "address")
public class AddressEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String street;
	private String postcode;
	private String telephone;
	private String email;

	protected AddressEntity() {
	}

	public AddressEntity(String name) {
		this.name = name;
	}

	public AddressEntity(String name, String street, String postcode, String telephone, String email) {
		super();
		this.name = name;
		this.street = street;
		this.postcode = postcode;
		this.telephone = telephone;
		this.email = email;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
