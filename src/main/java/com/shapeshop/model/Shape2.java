package com.shapeshop.model;

import java.awt.Color;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shape2 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id = -1;
	private int sides = 0;
	private Color color;
	
	protected Shape2() {}
	
	
	public Shape2(long id, int sides, Color color) {
//		this.id = id;
		this.sides = sides;
		this.color = color;
	}

	public Shape2(long id, int sides) {
//		this.id = id;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
