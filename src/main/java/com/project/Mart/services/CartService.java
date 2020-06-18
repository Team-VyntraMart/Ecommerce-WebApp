package com.project.Mart.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Mart.models.AddtoCart;
import com.project.Mart.models.CheckoutCart;

@Service
public interface CartService {
	
	List<AddtoCart> addCartbyUserIdAndProductId(long productId,long userId,int qty) throws Exception;
	void updateQtyByCartId(long cartId,int qty) throws Exception;
	List<AddtoCart> getCartByUserId(long userId);
	void deleteProductFromCart(long id,long userId);
	void deleteAllFromCart(long userId);
	
	//Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
	List<CheckoutCart> getAllCheckoutByUserId(long userId);
	List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;
	
	
	//CheckOutCart
}