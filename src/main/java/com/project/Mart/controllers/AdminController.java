package com.project.Mart.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Mart.RequestResponse.ApiResponse;
import com.project.Mart.config.ShoppingConfiguration;
import com.project.Mart.models.Category;
import com.project.Mart.models.Products;
import com.project.Mart.services.ProductServicesImpl;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	@Autowired
	ProductServicesImpl productServices;
	
	@RequestMapping("/addProduct")
  	public ResponseEntity<?> addProduct(@RequestBody HashMap<String,String> addProductRequest) {
		try {
			String keys[] = {"name","category_id","price"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addProductRequest)) {
				
			}
			String name = addProductRequest.get("name"); 
			String category_id =  addProductRequest.get("category_id"); 
			double price =  Double.parseDouble(addProductRequest.get("price")); 
			List<Products> obj = productServices.addProducts(name,category_id,price);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Product not inserted"));
		}
		
   }
	
	@RequestMapping("/addCategory")
  	public ResponseEntity<?> addCategory(@RequestBody HashMap<String,String> addCategoryRequest) {
		try {
			String keys[] = {"name"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addCategoryRequest)) {
				
			}
			String name = addCategoryRequest.get("name"); 
			List<Category> obj = productServices.addCategories(name);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Category not added"));
		}
		
   }

}
