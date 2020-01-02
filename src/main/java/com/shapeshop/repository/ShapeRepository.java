package com.shapeshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.model.Shape2;

public interface ShapeRepository extends CrudRepository<Shape2, Long>{

	List<Shape2> findBySides(int sides);
	
	Shape2 findById(long id);
	
	
}
