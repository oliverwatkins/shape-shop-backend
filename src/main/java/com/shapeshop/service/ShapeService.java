//package com.shapeshop.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.shapeshop.entity.ShapeEntity;
//import com.shapeshop.repository.ShapeRepository;
//
//import lombok.NoArgsConstructor;
//
//@Service
//@NoArgsConstructor
//public class ShapeService {
//
//	@Autowired
//	ShapeRepository shapeRepository;
//
//	public ShapeEntity createShape(ShapeEntity shape) {
//		shapeRepository.save(shape);
//		return shape;
//	}
//
//	public void deleteShape(long id) {
//		shapeRepository.deleteById(id);
//	}
//	public void deleteShape(ShapeEntity shape) {
//		shapeRepository.delete(shape);
//	}
//
//	public List<ShapeEntity> getAllShapes() {
//
//		List<ShapeEntity> result = StreamSupport.stream(shapeRepository.findAll().spliterator(), false)
//				.collect(Collectors.toList());
//		return result;
//	}
//
//	public ShapeEntity getShapeById(long id) {
//		return shapeRepository.findById(id);
//	}
//
//}
