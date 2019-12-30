package com.shapeshop.model;

import java.awt.Color;

public class Shape {
	
	private long id = -1;
	private int sides = 0;
	private Color color;
	
	public Shape(long id, int sides, Color color) {
		super();
		this.id = id;
		this.sides = sides;
		this.color = color;
	}

	public Shape(long id, int sides) {
		super();
		this.id = id;
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
