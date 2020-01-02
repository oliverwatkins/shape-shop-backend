package com.shapeshop.controller;

import java.awt.Color;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shapeshop.model.Bazz;
import com.shapeshop.model.Shape;
import com.shapeshop.service.ShapeService;


@RestController
public class ShapeController {

    @Autowired
    private ShapeService shapeService;
    
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/shapes2", method = RequestMethod.GET, headers = "Accept=application/json")
	public Shape[] shapes2() {
		
		List<Shape> itemList = shapeService.getAllShapes();
		
		Shape[] shapes2 = new Shape[itemList.size()];
		
		return shapeService.getAllShapes().toArray(shapes2);
	}

	@RequestMapping(value = "/ex/foos/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePathWithPathVariable(@PathVariable("id") long id) {
		return "Get a specific Foo with id=" + id;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBazz(@PathVariable String id) {
		return new ResponseEntity<>(new Bazz(id, "Bazz" + id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> newBazz(@RequestParam("name") String name) {
		return new ResponseEntity<>(new Bazz("5", name), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBazz(@PathVariable String id, @RequestParam("name") String name) {
		return new ResponseEntity<>(new Bazz(id, name), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBazz(@PathVariable String id) {
		return new ResponseEntity<>(new Bazz(id), HttpStatus.OK);
	}

}
