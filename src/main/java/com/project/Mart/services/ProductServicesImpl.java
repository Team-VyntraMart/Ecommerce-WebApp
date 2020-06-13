package com.project.Mart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Mart.models.Products;
import com.project.Mart.repositories.ProductRepository;

@Service
public class ProductServicesImpl implements ProductServices{

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<Products>getAllProducts(){
		return productRepo.findAll();
	}
	
	@Override
	public Products getProductsById(long productId) throws Exception {
		return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
	}

	@Override
	public void deleteByProductId(Long id) {
		productRepo.deleteById(id);
	}
	
	@Override
	public List<Products> addProducts(String name,double price) throws Exception{
			Products obj = new Products();
			obj.setName(name);
			obj.setPrice(price);
			productRepo.saveAndFlush(obj);		
			return null;
	}

	@Override
	public List<Products> findAll(String searchText) {
		return productRepo.findProduct(searchText);
	}
}