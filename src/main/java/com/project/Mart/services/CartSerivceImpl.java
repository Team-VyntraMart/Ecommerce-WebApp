package com.project.Mart.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Mart.models.AddtoCart;
import com.project.Mart.models.CheckoutCart;
import com.project.Mart.models.Products;
import com.project.Mart.repositories.AddtoCartRepository;
import com.project.Mart.repositories.CheckoutRepository;

@Service
public class CartSerivceImpl implements CartService {

	@Autowired
	AddtoCartRepository addCartRepo;
	@Autowired
	CheckoutRepository checkOutRepo;
	@Autowired
	ProductServicesImpl proServices;
    private static final Logger logger = LoggerFactory.getLogger(CartSerivceImpl.class);

	@Override
	public List<AddtoCart> addCartbyUserIdAndProductId(long productId, long userId,int qty) throws Exception {
		try {
			//if(addCartRepo.getCartByProductIdAnduserId(userId, productId).isPresent()){
			if(addCartRepo.getCartByProductIdAnduserId(userId, productId).isPresent()){
				throw new Exception("Product already exists.");
			}
			AddtoCart obj = new AddtoCart();
			obj.setQty(qty);
			obj.setUser_id(userId);
			Products pro = proServices.getProductsById(productId);
			obj.setProduct(pro); 
			addCartRepo.save(obj);		
			return this.getCartByUserId(userId);	
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public List<AddtoCart> getCartByUserId(long userId) {
		return addCartRepo.getCartByuserId(userId);
	}

	@Override
	public void updateQtyByCartId(long cartId, int qty) throws Exception {
		addCartRepo.updateQtyByCartId(cartId,qty);
	}

	/*@Override
	public Boolean checkTotalAmountAgainstCart(double totalAmount,long userId) {
		double total_amount =addCartRepo.getTotalAmountByUserId(userId);
		if(total_amount == totalAmount) {
			return true;
		}
		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
		return false;
	}*/

	@Override
	public List<CheckoutCart> getAllCheckoutByUserId(long userId) {
		return checkOutRepo.getByuserId(userId);
	}

	@Override
	public List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp) throws Exception {
		try {
			long user_id = tmp.get(0).getUser_id();
			if(tmp.size() >0) {
				checkOutRepo.saveAll(tmp);
				this.deleteAllFromCart(user_id);
				return this.getAllCheckoutByUserId(user_id);
			}	
			else {
				throw  new Exception("Should not be empty");
			}
		}catch(Exception e) {
			throw new Exception("Error while checkout "+e.getMessage());
		}
		
	}

	@Override
	public void deleteProductFromCart(long id, long userId) {
		addCartRepo.deleteCartByIdAndUserId(userId, id);
	}

	@Override
	public void deleteAllFromCart(long userId) {
		addCartRepo.deleteAllCartByUserId(userId);
	}

}
