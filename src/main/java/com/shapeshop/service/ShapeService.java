package com.shapeshop.service;
//package service;
//
import java.awt.Color;

import org.springframework.stereotype.Service;

import com.shapeshop.model.Shape;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ShapeService {

	public Shape[] getAllShapes() {
		
		Shape shape1 = new Shape(1, 3);
		Shape shape2 = new Shape(2, 4);
		Shape shape3 = new Shape(3, 5);

		Shape[] sArray = new Shape[3];
		sArray[0] = shape1;
		sArray[1] = shape2;
		sArray[2] = shape3;

		return sArray;
	}
}
