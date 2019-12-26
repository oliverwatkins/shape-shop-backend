package controller;
//package hello;
//
//import java.awt.Color;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import model.Bazz;
//import model.Shape;
//import service.ShapeService;
//
//@RestController
//public class ShapeController {
//
//    @Autowired
//    private ShapeService shapeService;
//    
//	@RequestMapping("/")
//	public String index() {
//		return "Greetings from Spring Boot!";
//	}
//
//	@RequestMapping(value = "/shapes", method = RequestMethod.GET, headers = "Accept=application/json")
//	public Shape[] shapes() {
//		return shapeService.getAllShapes();
//	}
//
//	@RequestMapping(value = "/shapes/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
//	public Shape shapes2(@PathVariable("id") int id) {
//		
//		Shape shape1 = new Shape(1, 3, Color.DARK_GRAY);
//		Shape shape2 = new Shape(2, 4, Color.GREEN);
//		Shape shape3 = new Shape(3, 5, Color.BLUE);
//
//		Shape[] sArray = new Shape[3];
//		sArray[0] = shape1;
//		sArray[1] = shape2;
//		sArray[2] = shape3;
//
//
//		return sArray[id];
//	}
//
//	@RequestMapping(value = "/ex/foos/{id}", method = RequestMethod.GET)
//	@ResponseBody
//	public String getFoosBySimplePathWithPathVariable(@PathVariable("id") long id) {
//		return "Get a specific Foo with id=" + id;
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getBazz(@PathVariable String id) {
//		return new ResponseEntity<>(new Bazz(id, "Bazz" + id), HttpStatus.OK);
//	}
//
//	@PostMapping
//	public ResponseEntity<?> newBazz(@RequestParam("name") String name) {
//		return new ResponseEntity<>(new Bazz("5", name), HttpStatus.OK);
//	}
//
//	@PutMapping("/{id}")
//	public ResponseEntity<?> updateBazz(@PathVariable String id, @RequestParam("name") String name) {
//		return new ResponseEntity<>(new Bazz(id, name), HttpStatus.OK);
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> deleteBazz(@PathVariable String id) {
//		return new ResponseEntity<>(new Bazz(id), HttpStatus.OK);
//	}
//
//}
