package com.shapeshop.model;

public class Bazz {
	
	String id;
	String string;

	public Bazz(String id, String string) {
		this.id = id;
		this.string = string;
	}

	public Bazz(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}



}
