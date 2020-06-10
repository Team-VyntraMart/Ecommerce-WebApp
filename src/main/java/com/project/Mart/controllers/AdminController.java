package com.project.Mart.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@PostMapping("/addProduct")
  	public ResponseEntity<?> addProduct(@RequestBody HashMap<String,String> addProductRequest) {
		try {
			String keys[] = {"name","category_id","price"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addProductRequest)) {
				
			}
			String name = addProductRequest.get("name"); 
			long category_id =  Long.parseLong(addProductRequest.get("category_id")); 
			double price =  Double.parseDouble(addProductRequest.get("price")); 
			List<Products> obj = productServices.addOrUpdateProducts(name,category_id,price);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Product not inserted"));
		}
	}
	
	@PutMapping("/addProduct")
  	public ResponseEntity<?> updateProduct(@RequestBody HashMap<String,String> updateProductRequest) {
		try {
			String keys[] = {"name","category_id","price"};
			if(ShoppingConfiguration.validationWithHashMap(keys, updateProductRequest)) {
				
			}
			String name = updateProductRequest.get("name"); 
			long category_id =  Long.parseLong(updateProductRequest.get("category_id")); 
			double price =  Double.parseDouble(updateProductRequest.get("price")); 
			List<Products> obj = productServices.addOrUpdateProducts(name,category_id,price);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Product not updated"));
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
	
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		productServices.deleteByProductId(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/deleteProduct/{cat_id}/{pro_id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteProductByCatId(@PathVariable Long cat_id, @PathVariable Long pro_id){
		productServices.deleteByProductIdAndCategoryId(pro_id, cat_id);;
		return ResponseEntity.ok().build();
	}

}
