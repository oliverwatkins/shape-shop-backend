package com.shapeshop.service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.model.Shape;
import com.shapeshop.model.Shape2;
import com.shapeshop.repository.ShapeRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ShapeService {
	
    @Autowired
	ShapeRepository shapeRepository;

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
	

	public List<Shape2> getAllShapes2() {
		
		List<Shape2> result = 
				  StreamSupport.stream(shapeRepository.findAll().spliterator(), false)
				    .collect(Collectors.toList());
		return result;
		
//		return shapeRepository.findAll();
	}

	
}
