package com.shapeshop.service;

import org.springframework.stereotype.Service;

import com.shapeshop.model.Bazz;

import lombok.NoArgsConstructor;


@Service
@NoArgsConstructor
public class BazzService {
	public Bazz[] getAllBazz() {
	
		Bazz shape1 = new Bazz("1");
		Bazz shape2 = new Bazz("2");
		Bazz shape3 = new Bazz("3");

		Bazz[] sArray = new Bazz[3];
		sArray[0] = shape1;
		sArray[1] = shape2;
		sArray[2] = shape3;

		return sArray;
	}
}
