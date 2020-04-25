package com.project.Mart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Mart.models.Category;
import com.project.Mart.models.Products;
import com.project.Mart.repositories.CategoryRepository;
import com.project.Mart.repositories.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository cateRepo;
	
	public List<Products>getAllProducts(){
		return productRepo.findAll();
	}
	public List<Products>getProductsByCategory(String product_id){
		return productRepo.getByCategoryId(product_id);
	}
	
	public List<Category>getAllCategory(){
		return cateRepo.findAll();
	}
	
	public Products getProductsById(long productId) throws Exception {
		return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
	}
}