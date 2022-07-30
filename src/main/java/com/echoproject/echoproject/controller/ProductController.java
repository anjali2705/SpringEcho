package com.echoproject.echproject.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.echoproject.echoproject.model.Product;
import com.echoproject.echoproject.service.ProductService;
 
@RestController
@RequestMapping("/api")
public class ProductController {
 
    @Autowired
    private ProductService service;
     
    Product product = new Product();
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/images";
    // RESTful API methods for Retrieval operations
     
    @GetMapping("/products")
    public List<Product> list() {
        return service.listAll();
    }
    
    // RESTful API method for Create operation
     
    
    @PostMapping(value="/saveProduct", consumes = { "multipart/form-data" } )
    public String add(
    		           @RequestParam("product_name") String name,
    		           @RequestParam("price") double price,
    		           @RequestParam("added_on") String createdat,
    		           @RequestParam("category_id") int category,
    		           @RequestParam("productimage") MultipartFile file) {
       StringBuilder fileNames = new StringBuilder();
       
    	String filename = file.getOriginalFilename();
    	Path fileNameAndPath = Paths.get(uploadDirectory, filename);
    	try{
    		Files.write(fileNameAndPath, file.getBytes());
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    	  
    	product.setProduct_name(name);
    	product.setPrice(price);
    	product.setAdded_on(createdat);
    	product.setCategory_id(category);
    	product.setProductimage(filename);
    	 service.save(product);
    	return "saved data Successfully";
    }
    
    
    //Get All Products
    
    @GetMapping("/getAll")
    @CrossOrigin("http://localhost:3000")
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
     */
    // RESTful API method for Delete operation
   
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
    	int productid = (int)id;
        service.delete(productid);
    }

    
     
    @GetMapping("/products/{id}")
    @CrossOrigin("http://localhost:3000")
    public Optional<Product> getProductById(@PathVariable Integer id) throws Exception {  
            return  service.fetchProductById(id);   
    }
    
    @GetMapping( value = "/getimage/{img_name}",produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable("img_name") String img_name) throws IOException {
	      
    	InputStream in = getClass().getResourceAsStream("/images/"+img_name);
	    return IOUtils.toByteArray(in);
	}
   
}