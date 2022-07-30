package com.echoproject.echoproject.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   // Auto Increment Id
    private int product_id;
    private String product_name;
    private double price;
    private String added_on;
    private int category_id;
    private String productimage;   
 
    public Product() {
    }


	public Product(int product_id, String product_name, double price, String added_on, int category_id, String productimage) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.added_on = added_on;
		this.category_id = category_id;
		this.productimage = productimage;
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getAdded_on() {
		return added_on;
	}


	public void setAdded_on(String added_on) {
		this.added_on = added_on;
	}


	public int getCategory_id() {
		return category_id;
	}


	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}


	public String getProductimage() {
		return productimage;
	}


	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}



   
 
   
}