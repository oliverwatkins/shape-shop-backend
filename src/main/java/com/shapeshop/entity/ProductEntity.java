package com.shapeshop.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "category", nullable = false, updatable = false)
	private CategoryEntity category = new CategoryEntity();

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false, updatable = false)
	private CompanyEntity company = new CompanyEntity();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<OrderItemEntity> orders = new ArrayList<>();

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private BigDecimal price;

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

	public ProductEntity(String name, BigDecimal price, String type, String imageFilename, CompanyEntity company, String description, CategoryEntity categoryEntity) {
		super();
		this.description = description;
		this.name = name;
		this.price = price;
		this.type = type;
		this.imageFilename = imageFilename;
		this.company = company;
		this.category = categoryEntity;
	}
	public ProductEntity(String name, BigDecimal price, String type, String imageFilename, CompanyEntity company) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.imageFilename = imageFilename;
		this.company = company;
	}

//	public ProductEntity(String hamburger, BigDecimal bigDecimal, String main, String s, CompanyEntity ce, String a_hamburger, CategoryEntity categoryEntity) {
//	}
}
