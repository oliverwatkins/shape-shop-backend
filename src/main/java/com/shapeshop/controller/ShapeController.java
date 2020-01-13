package com.shapeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shapeshop.entity.Shape;
import com.shapeshop.service.ShapeService;


@RestController
public class ShapeController {

	@Autowired
	private ShapeService shapeService;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@PostMapping("/shapes")
	public ResponseEntity<?> newShape(@RequestBody Shape shape) {
		Shape s = shapeService.createShape(shape);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@GetMapping(value = "/shapes")
	public Shape[] shapes() {
		List<Shape> itemList = shapeService.getAllShapes();
		Shape[] shapes2 = new Shape[itemList.size()];
		return shapeService.getAllShapes().toArray(shapes2);
	}

	@GetMapping(value = "/shapes/{id}")
	public Shape getShapesById(@PathVariable("id") long id) {
		Shape item = shapeService.getShapeById(id);
		return item;
	}

	@DeleteMapping(value = "/shapes/{id}")
	public void deleteShapesById(@PathVariable("id") long id) {
		shapeService.deleteShape(id);
	}

	@DeleteMapping(value = "/shapes")
	public void deleteShapes(@RequestBody Shape shape) {
		shapeService.deleteShape(shape);
	}
}
