package com.shapeshop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.Shape;
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

	public void deleteShape(long id) {
		shapeRepository.deleteById(id);
	}
	public void deleteShape(Shape shape) {
		shapeRepository.delete(shape);
	}

	public List<Shape> getAllShapes() {

		List<Shape> result = StreamSupport.stream(shapeRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return result;
	}

	public Shape getShapeById(long id) {
		return shapeRepository.findById(id);
	}

}
