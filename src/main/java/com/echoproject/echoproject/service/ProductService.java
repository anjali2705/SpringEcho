package com.echoproject.echoproject.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.echoproject.echoproject.model.Product;
import com.echoproject.echoproject.repository.ProductRepository;
 
@Service
@Transactional
public class ProductService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<Product> listAll() {
        return repo.findAll();
    }
     
    public void save(Product product) {
        repo.save(product);
    }
     
  
     
    public void delete(int id) {
        repo.deleteById(id);
    }

    public List<Product>getAllProducts(){
		return repo.findAll();
	}

  

	public Product getProductById(long productId) {
		// TODO Auto-generated method stub
		return repo.getById((int)productId);
	}

	public Optional<Product> fetchProductById(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
}