package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Bazz;

@RestController
public class CrudExampleController {
    
    @GetMapping("/crud/{id}")
    public ResponseEntity<?> getBazz(@PathVariable String id){
        return new ResponseEntity<>(new Bazz(id, "Bazz"+id), HttpStatus.OK);
    }
     
    @PostMapping("/crud")
    public ResponseEntity<?> newBazz(@RequestParam("name") String name){
        return new ResponseEntity<>(new Bazz("5", name), HttpStatus.OK);
    }
     
    @PutMapping("/crud/{id}")
    public ResponseEntity<?> updateBazz(
      @PathVariable String id,
      @RequestParam("name") String name) {
        return new ResponseEntity<>(new Bazz(id, name), HttpStatus.OK);
    } 
     
    @DeleteMapping("/crud/{id}")
    public ResponseEntity<?> deleteBazz(@PathVariable String id){
        return new ResponseEntity<>(new Bazz(id), HttpStatus.OK);
    }
    

}


