package com.echoproject.echoproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.echoproject.echoproject.model.AddtoCart;
import com.echoproject.echoproject.model.CheckoutCart;
import com.echoproject.echoproject.model.Product;
@Service
public interface CartService {
	List<AddtoCart> addCartbyUserIdAndProductId(long productId,long userId,int qty,double price) throws Exception;
	void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
	List<AddtoCart> getCartByUserId(long userId);
	List<AddtoCart> removeCartByUserId(long cartId,long userId);
	List<AddtoCart> removeAllCartByUserId(long userId);
	Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
	List<CheckoutCart> getAllCheckoutByUserId(long userId);
	List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;
	void save(AddtoCart cart);
	List<AddtoCart> fetchCartByUserId(Integer id);
	
	
	//CheckOutCart
}