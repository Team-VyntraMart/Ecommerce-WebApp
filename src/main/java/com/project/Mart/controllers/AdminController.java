package com.project.Mart.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.Mart.RequestResponse.ApiResponse;
import com.project.Mart.config.ShoppingConfiguration;
import com.project.Mart.models.Products;
import com.project.Mart.repositories.ProductRepository;
import com.project.Mart.services.ProductServicesImpl;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:8015")
public class AdminController {
	
	@Autowired
	ProductServicesImpl productServices;
	
	@Autowired
	ProductRepository productRepo;
	
	@PostMapping("/addProduct")
  	public ResponseEntity<?> addProduct(@RequestBody HashMap<String,String> addProductRequest) {
		try {
			String keys[] = {"name","price","imageURL"};
			if(ShoppingConfiguration.validationWithHashMap(keys, addProductRequest)) {
				
			}
			String name = addProductRequest.get("name");  
			double price =  Double.parseDouble(addProductRequest.get("price"));
			String imageURL = addProductRequest.get("imageURL");
			List<Products> obj = productServices.addProducts(name,price,imageURL);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Product not inserted"));
		}
	}
	
	@RequestMapping(value="/updateProduct/{id}", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
  	public ResponseEntity<?> updateProduct(@RequestBody HashMap<String,String> updateProductRequest, @PathVariable Long id) {
		try {
			String keys[] = {"name","price","imageURL"};
			if(ShoppingConfiguration.validationWithHashMap(keys, updateProductRequest)) {
				
			}
			String name = updateProductRequest.get("name");  
			double price =  Double.parseDouble(updateProductRequest.get("price"));
			String imageURL = updateProductRequest.get("imageURL");
			Products obj = productServices.getProductsById(id);
			obj.setName(name);
			obj.setPrice(price);
			obj.setImageURL(imageURL);
			productRepo.saveAndFlush(obj);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(false, "Product not updated"));
		}
	}
	
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		productServices.deleteByProductId(id);
		return ResponseEntity.ok().build();
	}
}
