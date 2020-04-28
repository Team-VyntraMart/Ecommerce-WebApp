package com.project.Mart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Mart.models.Category;
import com.project.Mart.models.Products;
import com.project.Mart.repositories.CategoryRepository;
import com.project.Mart.repositories.ProductRepository;

@Service
public class ProductServicesImpl implements ProductServices{

	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository cateRepo;
	
	@Override
	public List<Products> addProducts(String name,String category_id,double price) throws Exception{
			Products obj = new Products();
			obj.setName(name);
			obj.setCategory_id(category_id);
			obj.setPrice(price);
			productRepo.save(obj);		
			return productRepo.getByCategoryId(category_id);
	}
	
	@Override
	public List<Category> addCategories(String name) {
			Category obj = new Category();
			obj.setName(name);
			cateRepo.save(obj);
			return null;
	}
	
	@Override
	public List<Products>getAllProducts(){
		return productRepo.findAll();
	}
	
	@Override
	public List<Products>getProductsByCategory(String product_id){
		return productRepo.getByCategoryId(product_id);
	}
	
	@Override
	public List<Category>getAllCategory(){
		return cateRepo.findAll();
	}
	
	@Override
	public Products getProductsById(long productId) throws Exception {
		return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
	}
}