package com.project.Mart.services.ProductService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Mart.repositories.CategoryRepository;
import com.project.Mart.repositories.ProductRepository;
import com.project.Mart.models.CategoryModel;
import com.project.Mart.models.ProductsModel;

@Service
public class ProductServices {

	@Autowired
	ProductRepository productRepo;
	@Autowired
	CategoryRepository cateRepo;
	
	public List<ProductsModel>getAllProducts(){
		return productRepo.findAll();
	}
	public List<ProductsModel>getProductsByCategory(String product_id){
		return productRepo.getByCategoryId(product_id);
	}
	
	public List<CategoryModel>getAllCategory(){
		return cateRepo.findAll();
	}
	
	public ProductsModel getProductsById(long productId) throws Exception {
		return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
	}
}
