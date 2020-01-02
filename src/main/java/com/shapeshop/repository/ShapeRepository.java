package com.shapeshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.model.Shape;

public interface ShapeRepository extends CrudRepository<Shape, Long>{

	List<Shape> findBySides(int sides);
	
	Shape findById(long id);
	
}
