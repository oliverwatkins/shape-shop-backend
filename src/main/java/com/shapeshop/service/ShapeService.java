package com.shapeshop.service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.model.Shape;
import com.shapeshop.repository.ShapeRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ShapeService {
	
    @Autowired
	ShapeRepository shapeRepository;



	public Shape createShape(Shape shape) {
		shapeRepository.save(shape);
		return shape;
	}
//	public Shape createShape(String name) {
//		Shape s = new Shape(name);
//		shapeRepository.save(s);
//		return s;
//	}
//	public Shape updateShape(Shape) {
//		
//		return null;
//	}
	
	public Shape deleteShape(long id) {
		
		return null;
	}

    
	public List<Shape> getAllShapes() {
		
		List<Shape> result = 
				  StreamSupport.stream(shapeRepository.findAll().spliterator(), false)
				    .collect(Collectors.toList());
		return result;
	}



}
