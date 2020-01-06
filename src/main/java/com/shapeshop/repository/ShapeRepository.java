package com.shapeshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.model.Shape;

public interface ShapeRepository extends CrudRepository<Shape, Long>{

    public Shape findById(long id);
    
    public List<Shape> findByName(String lastName);
	
	List<Shape> findBySides(int sides);
	
}
