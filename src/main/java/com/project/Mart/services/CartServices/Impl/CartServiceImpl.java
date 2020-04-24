package com.project.Mart.services.CartServices.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Mart.repositories.AddtoCartRepository;
import com.project.Mart.repositories.CheckoutRepository;
import com.project.Mart.models.AddtoCartModel;
import com.project.Mart.models.CheckoutCartModel;
import com.project.Mart.models.ProductsModel;
import com.project.Mart.services.CartServices.CartService;
import com.project.Mart.services.ProductService.ProductServices;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	AddtoCartRepository addCartRepo;
	@Autowired
	CheckoutRepository checkOutRepo;
	@Autowired
	ProductServices proServices;
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	@Override
	public List<AddtoCartModel> addCartbyUserIdAndProductId(long productId, long userId,int qty,double price) throws Exception {
		try {
			if(addCartRepo.getCartByProductIdAnduserId(userId, productId).isPresent()){
				throw new Exception("Product is already exist.");
			}
			AddtoCartModel obj = new AddtoCartModel();
			obj.setQty(qty);
			obj.setUser_id(userId);
			ProductsModel pro = proServices.getProductsById(productId);
			obj.setProduct(pro); 
			//TODO price has to check with qty
			obj.setPrice(price);
			addCartRepo.save(obj);		
			return this.getCartByUserId(userId);	
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(""+e.getMessage());
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public List<AddtoCartModel> getCartByUserId(long userId) {
		return addCartRepo.getCartByuserId(userId);
	}

	@Override
	public List<AddtoCartModel> removeCartByUserId(long cartId, long userId) {
		addCartRepo.deleteCartByIdAndUserId(userId, cartId);
		return this.getCartByUserId(userId);
	}

	@Override
	public void updateQtyByCartId(long cartId, int qty, double price) throws Exception {
		addCartRepo.updateQtyByCartId(cartId,price,qty);
	}

	@Override
	public Boolean checkTotalAmountAgainstCart(double totalAmount,long userId) {
		double total_amount =addCartRepo.getTotalAmountByUserId(userId);
		if(total_amount == totalAmount) {
			return true;
		}
		System.out.print("Error from request "+total_amount +" --db-- "+ totalAmount);
		return false;
	}

	@Override
	public List<CheckoutCartModel> getAllCheckoutByUserId(long userId) {
		return checkOutRepo.getByuserId(userId);
	}

	@Override
	public List<CheckoutCartModel> saveProductsForCheckout(List<CheckoutCartModel> tmp) throws Exception {
		try {
			long user_id = tmp.get(0).getUser_id();
			if(tmp.size() >0) {
				checkOutRepo.saveAll(tmp);
				this.removeAllCartByUserId(user_id);
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
	public List<AddtoCartModel> removeAllCartByUserId(long userId) {
		addCartRepo.deleteAllCartByUserId(userId);
		return null;
	}

}
