package com.project.Mart.services.CartServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Mart.models.AddtoCartModel;
import com.project.Mart.models.CheckoutCartModel;
import com.project.Mart.models.ProductsModel;

@Service
public interface CartService {
	List<AddtoCartModel> addCartbyUserIdAndProductId(long productId,long userId,int qty,double price) throws Exception;
	
	void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
	
	List<AddtoCartModel> getCartByUserId(long userId);
	List<AddtoCartModel> removeCartByUserId(long cartId,long userId);
	List<AddtoCartModel> removeAllCartByUserId(long userId);
	Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
	List<CheckoutCartModel> getAllCheckoutByUserId(long userId);
	List<CheckoutCartModel> saveProductsForCheckout(List<CheckoutCartModel> tmp)  throws Exception;
	
	
	//CheckOutCart
}