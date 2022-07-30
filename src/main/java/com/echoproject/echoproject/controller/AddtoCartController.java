package com.echoproject.echproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.echoproject.echoproject.model.AddtoCart;
import com.echoproject.echoproject.model.Product;
import com.echoproject.echoproject.service.CartService;
import com.echoproject.echproject.controller.RequestPojo.ApiResponse;



@RestController
@RequestMapping("api/addtocart")
public class AddtoCartController {
	
	@Autowired
	CartService cartService;
	@PostMapping("addProduct")
  	public ResponseEntity<?> addCartwithProduct(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"productId","userId","qty","price"};
//			if(ShoppingConfiguration.validationWithHashMap(keys, addCartRequest)) {
//			
//		}
			long productId = Long.parseLong(addCartRequest.get("productId")); 
			long userId =  Long.parseLong(addCartRequest.get("userId")); 
			int qty =  Integer.parseInt(addCartRequest.get("qty")); 
			double price = Double.parseDouble(addCartRequest.get("price"));
			List<AddtoCart> obj = cartService.addCartbyUserIdAndProductId(productId,userId,qty,price);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
		
   }
	
	
	//Second method of add product in cart
	
	 @PostMapping("/cart")
	 @CrossOrigin("http://localhost:3000")
	    public void add(@RequestBody AddtoCart cart) {
		 cartService.save(cart);
	    }
	
	@RequestMapping("updateQtyForCart")
  	public ResponseEntity<?> updateQtyForCart(@RequestBody HashMap<String,String> addCartRequest) {
		try {
			String keys[] = {"cartId","userId","qty","price"};
		
			long cartId = Long.parseLong(addCartRequest.get("cartId")); 
			long userId =  Long.parseLong(addCartRequest.get("userId")); 
			int qty =  Integer.parseInt(addCartRequest.get("qty")); 
			double price = Double.parseDouble(addCartRequest.get("price"));
			 cartService.updateQtyByCartId(cartId, qty, price);
			 List<AddtoCart> obj = cartService.getCartByUserId(userId);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
		
   }
	
	
	@RequestMapping("removeProductFromCart")
  	public ResponseEntity<?> removeCartwithProductId(@RequestBody HashMap<String,String> removeCartRequest) {
		try {
			String keys[] = {"userId","cartId"};
			
			List<AddtoCart> obj = cartService.removeCartByUserId(Long.parseLong(removeCartRequest.get("cartId")), Long.parseLong(removeCartRequest.get("userId")));
			return ResponseEntity.ok(obj);
		}catch(Exception e) {
				return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}		
   }
	
	
	
	
	@RequestMapping("getCartsByUserId")
  	public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String,String> getCartRequest) {
		try {
			String keys[] = {"userId"};
			
			List<AddtoCart> obj = cartService.getCartByUserId(Long.parseLong(getCartRequest.get("userId")));
			return ResponseEntity.ok(obj);
		}catch(Exception e) {
				return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}	
   }
	
	 @GetMapping("/getCartData/{id}")
	    @CrossOrigin("http://localhost:3000")
	    public List<AddtoCart> getCartById(@PathVariable Integer id) throws Exception {  
	            return  cartService.fetchCartByUserId(id);   
	    }
}
