package com.echoproject.echproject.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echoproject.echoproject.model.Product;
import com.echoproject.echoproject.service.ProductService;
 
@RestController
@RequestMapping("/api")
public class ProductController {
 
    @Autowired
    private ProductService service;
     
    // RESTful API methods for Retrieval operations
     
    @GetMapping("/products")
    public List<Product> list() {
        return service.listAll();
    }
    
    // RESTful API method for Create operation
     
    
    @PostMapping("/saveProduct")
    public void add(@RequestBody Product product) {
        service.save(product);
    }
    
    
    //Get All Products
    
    @GetMapping("/getAll")
	public List<Product> getAllPRoducts(){
		return service.getAllProducts();
	}
    
    @GetMapping( "items" )
    public String getStockItem() {
    	String test= "TestUrl";
       return test;
    }
    
    // RESTful API method for Update operation
  /*   
    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            Product existProduct = service.get(id);
            service.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    
    // RESTful API method for Delete operation
    
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    
    
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }      
    }
    */

}