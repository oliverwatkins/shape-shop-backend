package com.shapeshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shape {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int sides = 0;
	private String name;
	
	protected Shape() {}

	public Shape(String name) {
		this.name = name;
	}
	
	public Shape(String name, int sides) {
		this.name = name;
		this.sides = sides;
	}

	public Shape(long id, int sides) {
		this.sides = sides;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSides() {
		return sides;
	}
	
	public void setSides(int sides) {
		this.sides = sides;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Shape [id=" + id + ", sides=" + sides + ", name=" + name + "]";
	}
}
