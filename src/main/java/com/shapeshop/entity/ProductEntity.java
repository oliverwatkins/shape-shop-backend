package com.shapeshop.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "company_id_test", nullable = false, updatable = false)
	private CompanyEntity company = new CompanyEntity();


	@OneToMany
	private List<OrderItemEntity> orders = new ArrayList<>();

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private BigDecimal price;

	// mains / drinks etc.
	@Column(name = "type")
	private String type;

	@Column(name = "img_filename")
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
