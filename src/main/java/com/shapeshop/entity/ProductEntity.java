package com.shapeshop.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

	@ManyToOne
	private CompanyEntity company = new CompanyEntity();

	@Id
	@Column(name = "PRODUCT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany
	private List<OrderItemEntity> orders = new ArrayList<>();

	@Column(name = "PRODUCT_NAME")
	private String name;

	@Column(name = "PRODUCT_PRICE")
	private BigDecimal price;

	// mains / drinks etc.
	@Column(name = "PRODUCT_TYPE")
	private String type;

	@Column(name = "PRODUCT_IMG_FILENAME")
	private String imageFilename;

	protected ProductEntity() {
	}

	public ProductEntity(String name, CompanyEntity company) {
		this.name = name;
		this.company = company;
	}

	public ProductEntity(String name, BigDecimal price, String type, String imageFilename, CompanyEntity company) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.imageFilename = imageFilename;
		this.company = company;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageFilename() {
		return imageFilename;
	}

	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}

	@Override
	public String toString() {
		return "ProductEntity [company=" + company + ", id=" + id + ", orders=" + orders + ", name=" + name + ", price="
				+ price + ", type=" + type + ", imageFilename=" + imageFilename + "]";
	}
}
